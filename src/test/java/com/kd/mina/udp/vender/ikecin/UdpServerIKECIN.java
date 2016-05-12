package com.kd.mina.udp.vender.ikecin;

import com.kd.mina.udp.vender.MysqlConnection;
import com.kd.platform.web.system.service.SystemService;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class UdpServerIKECIN extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public static final int PORT = 60002;//ikecin默认端口60002
	public static List<String> devList;//存储控制开合状态列表
	public static Map<String,Map<String,String>> cacheDump;//存放zzsmartsocket ip state e_stats缓存值,目前只为监控使用
	public static List<Map<String,String>> cacheTemp;//存放临时表数据缓存
	private static NioDatagramAcceptor acceptor;
	static {
		devList = new ArrayList<String>();
		cacheDump = new HashMap<String, Map<String, String>>();
		cacheTemp = new ArrayList<Map<String,String>>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn  = MysqlConnection.getConn();
			String sql = "select mac_id , ip , port , status ,key_p from zz_smartsocket";
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			ResultSetMetaData rsm =rs.getMetaData();
			while (rs.next()) {
				String primaryKey = "";
				Map<String,String> map = new HashMap<String,String>();
				for (int i = 1; i <= col; i++) {
					String type = rsm.getColumnTypeName(i);
					String columnName = rsm.getColumnName(i);

					if(type.equals("VARCHAR")){
						String value = rs.getString(i);
						System.out.print(columnName+":"+value+"  ");

						if(i == 1){
							primaryKey = value;
						}else{
							map.put(columnName,value);
						}
					}
				}
				System.out.println("");
				String e_stats = getNewEStats(primaryKey);
				map.put("e_stats",e_stats);
				cacheDump.put(primaryKey,map);

			}
			System.out.println("cacheDump.size():"+cacheDump.size());

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static String getNewEStats(String mac_id){
		String sql = "select e_stats from zz_smartsocket_temp where mac_id = '"+mac_id+"' " +
				"and record_time = (select max(record_time) time  from zz_smartsocket_temp where mac_id = '"+mac_id+"' limit 1 )";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "";
		try{
			conn = MysqlConnection.getConn();
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				result = rs.getString(1);
				System.out.println("=================new Estats : "+result+"=====================");
			}
			if(result.equals("") || result == null){
				result = "0";
			}
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public UdpServerIKECIN() throws IOException {

		acceptor = new NioDatagramAcceptor();
		acceptor.setHandler(new UdpIKECINServerHandler(this));
		/**
		Executor threadPool = Executors.newCachedThreadPool();
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		LoggingFilter loggingFilter = new LoggingFilter();
		loggingFilter.setSessionClosedLogLevel(LogLevel.ERROR);
		loggingFilter.setSessionCreatedLogLevel(LogLevel.ERROR);
		loggingFilter.setSessionOpenedLogLevel(LogLevel.ERROR);

		chain.addLast("logger", loggingFilter);
		//注释以下2行代码解决handler message receive 由于"编码问题"无法获取客户端发送的信息

		 chain.addLast("codec", new ProtocolCodecFilter(new
		 TextLineCodecFactory(Charset.forName("UTF-8"))));
		chain.addLast("threadPool", new ExecutorFilter(threadPool));
		*/
		DatagramSessionConfig dcfg = acceptor.getSessionConfig();
		dcfg.setReadBufferSize(4096);// 设置接收最大字节默认2048
		dcfg.setMaxReadBufferSize(65536);
		dcfg.setReceiveBufferSize(1024);// 设置输入缓冲区的大小
		dcfg.setSendBufferSize(1024);// 设置输出缓冲区的大小
		dcfg.setReuseAddress(true);// 设置每一个非主监听连接的端口可以重用

		acceptor.bind(new InetSocketAddress(PORT));
		System.out.println("IKECIN UDPServer listening on port " + PORT);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("控制执行:===========UdpServerIKECIN.devList.size()"+UdpServerIKECIN.devList.size()+"====================");
				if(UdpServerIKECIN.devList.size() > 0){
					sendMessage(UdpServerIKECIN.devList);
				}
			}
		},1000,2000);

		//每30秒录入temp表中采集的数据
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("控制执行:===========UdpServerIKECIN.cacheTemp.size()"+UdpServerIKECIN.cacheTemp.size()+"====================");
				if(UdpServerIKECIN.cacheTemp.size() > 0) {
					List<Map<String,String>> tempList = UdpServerIKECIN.cacheTemp;
					insertTmp(tempList);
				}
			}
		},0,10000);
	}

	/**
	 * 获得客户端连接总数
	 * 
	 * @return
	 */
	public static int getConNum() {

		int num = acceptor.getManagedSessionCount();
		System.out.println("num:" + num);

		return num;
	}

	/**
	 * 向每个客户端发送消息
	 * 
	 * @return
	 */ 
	public static void sendConMessage() {

		IoSession session;

		Map conMap = acceptor.getManagedSessions();	

		Iterator iter = conMap.keySet().iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			session = (IoSession) conMap.get(key);
			session.write("" + key.toString());
		}

	}

	/**
	 * 接受前台WEB控制开合的指令,向客户端发送指令,控制设备 开合状态
	 * @param devList 每条信息中需要具备对应的IP地址,开合状态status,sn唯一标示,"
     */
	public static void sendMessage(List<String> devList) {
		//发送数据的套接字变量
        DatagramSocket ds = null;
        //UDP的数据包变量
        DatagramPacket dp = null;

        try{

        //实例化UDP的套接字,端口号为9999,UDP套接字绑定的端口
		/**
		 * 要发送的数据 设备关闭
		 * {"sn":"xxxxx","p_w":"123456","k_close":true,"seq":由APP端递增发送}
		 */
		List<String> processList = new ArrayList<String>();
			for (int i = 0; i < devList.size(); i++) {
				ds = new DatagramSocket();
				String devStr = devList.get(i);
				String[] devArr = devStr.split("#");
				String macId = devArr[0];
				String ip = devArr[1];
				String port = devArr[2];
				String k_close = devArr[3];
				String order = "{'sn':'"+macId+"','k_close':"+k_close+",'p_w':'123456'}";
				System.out.println(order);
				System.out.println(ip+":"+port);
				byte[] aaByte = order.toString().getBytes();
				//指定需要发送的数据内容,数据长度,目的IP和目的端口号
				dp = new DatagramPacket(aaByte,aaByte.length,InetAddress.getByName(ip),Integer.parseInt(port));
				//发送数据
				ds.send(dp);
				//关闭
				ds.close();
				processList.add(devStr);
				operateCache(macId,k_close);
			}
			devList.removeAll(processList);

        }catch(Exception e ){
        	e.printStackTrace();
        }
	}

	private static void operateCache(String mac_id,String k_close){
		Map<String,String> map = cacheDump.get(mac_id);
		map.put("status",k_close.equals("false")?"Y":"N");
	}

	public void insertTmp(List<Map<String,String>> cacheTemp ){
		String sql = " insert into zz_smartsocket_temp (id,mac_id,electric_quantity,state,record_time,e_stats,key_p,key_v,key_i) values ";
		java.util.Date date=new java.util.Date();
		Timestamp record_time=new Timestamp(date.getTime());
		for (int i = 0; i < cacheTemp.size(); i++) {
			Map<String,String> map = cacheTemp.get(i);
			String id = UUID.randomUUID().toString();
			String mac_id = map.get("mac_id");
			String electric_quantity = getElectricty(map);
			String state = map.get("status");

			String e_stats = map.get("e_stats");
			String key_p = map.get("key_p");
			String key_v = map.get("key_v");
			String key_i = map.get("key_i");
			sql += "('"+id+"','"+mac_id+"','"+electric_quantity+"','"+state+"','"+record_time+"','"+e_stats+"','"+key_p+"','"+key_v+"','"+key_i+"')";
			if(i == cacheTemp.size()-1){

			}else{
				sql += ",";
			}
		}
		System.out.println("batch sql:--------------->"+sql);

		Connection conn = MysqlConnection.getConn();
		PreparedStatement pstmt = null;
		try {
			Date start = new Date();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~开始执行批量插入时间:"+start+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			Date end = new Date();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~批量插入结束时间:"+end+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~批量插入共消耗时间:"+(end.getTime() - start.getTime())+"毫秒~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			UdpServerIKECIN.cacheTemp.removeAll(cacheTemp);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null ){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}


	}

	private String getElectricty(Map<String, String> map) {
		int electricity = Integer.parseInt(map.get("electricity").toString());
		String result = electricity/100 + "";
		return result;
	}

	public static void main(String[] args) throws IOException {
//		new UdpServerIKECIN();
		java.util.Date date=new java.util.Date();
		Timestamp record_time=new Timestamp(date.getTime());
		System.out.println(record_time);
		System.out.println(new java.util.Date().getTime());
	}

}