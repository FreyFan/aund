package com.kd.mina.udp.vender.ikecin;

import java.io.IOException;
import java.net.SocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.kd.platform.web.system.service.SystemService;


public class UdpIKECINServerHandler extends IoHandlerAdapter {

	private static Logger logger = Logger.getLogger(UdpIKECINServerHandler.class);
	private UdpServerIKECIN server;
	@Autowired
	private SystemService systemService;
	public UdpIKECINServerHandler(UdpServerIKECIN server) {
		this.server = server;
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
		session.close(true);
	}

	@Override
	public void messageReceived(IoSession session, Object message)  {
		SocketAddress remoteAddress = session.getRemoteAddress();
		IoBuffer ioBuffer = (IoBuffer)message;
		byte[] b = new byte[ioBuffer.limit()];
		ioBuffer.get(b);

		String UDPMsg = new String(b, 12, b.length - 12).trim();

		if (UDPMsg.isEmpty()) {
			return;
		}
		logger.info("UDPMsg:"+UDPMsg);
		final JSONObject result;
		try {
			result = new JSONObject(UDPMsg);
			String mac_id = result.getString("sn");
			String key_v = result.getInt("key_V")+"";
			String key_i = result.getInt("key_I")+"";
			String key_p = result.getInt("key_P")+"";
			String e_stats = result.getInt("E_stats")+"";
			Boolean k_close = result.getBoolean("k_close");
			String status = !k_close?"Y":"N";
			String[] addr = remoteAddress.toString().split(":");
			String ip = addr[0].substring(1,addr[0].length());
			String port = addr[1];
			System.out.println("mac_id:"+mac_id);
			System.out.println("key_v:"+key_v);
			System.out.println("key_i:"+key_i);
			System.out.println("key_p:"+key_p);
			System.out.println("e_stats:"+e_stats);
			System.out.println("k_close:"+k_close);
			System.out.println("status:"+status);
			System.out.println("ip:"+ip);
			System.out.println("port:"+port);
			// test by yangm
			Date nowTime=new Date(); 
			SimpleDateFormat time=new SimpleDateFormat("yyyy MM dd HH mm ss"); 
			System.out.println("yangm test time:"+time.format(nowTime));
			Map<String,String> newMap = new HashMap<String, String>();
			newMap.put("mac_id",mac_id);
			newMap.put("ip",ip);
			newMap.put("port",port);
			newMap.put("status",status);
			newMap.put("key_p",key_p);
			newMap.put("key_v",key_v);
			newMap.put("key_i",key_i);
			newMap.put("key_p",key_p);
			newMap.put("e_stats",e_stats);

			if(UdpServerIKECIN.cacheDump.containsKey(mac_id)){
				Map<String,String> map = UdpServerIKECIN.cacheDump.get(mac_id);
				Iterator iter = map.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry entry = (Map.Entry) iter.next();
						Object key = entry.getKey();
						Object val = entry.getValue();
						String targetKey = key.toString();
						String targetValue = val==null?"":val.toString();
						System.out.println("^^^^^old data :  ^^^^^"+targetKey+":^^^^^^^^["+targetValue+"]");

						if(targetKey.equalsIgnoreCase("e_stats")){

							int electricity = (e_stats.equals("")||e_stats == null ? 0:Integer.parseInt(e_stats)) -
									(targetValue.equals("")||targetValue == null ? 0:Integer.parseInt(targetValue));
							if(electricity < 0){
								electricity = e_stats.equals("")||e_stats == null ? 0:Integer.parseInt(e_stats);
							}
							Map<String ,String > oldMap  = UdpServerIKECIN.cacheDump.get(mac_id);
							oldMap.put("e_stats",e_stats);//内存更新电量值
							UdpServerIKECIN.cacheDump.put(mac_id,oldMap);
							newMap.put("electricity",electricity+"");

							UdpServerIKECIN.cacheTemp.add(newMap);
						}

						if(targetKey.equalsIgnoreCase("ip")){
							if(!ip.equals(targetValue)){
								UdpServerIKECIN.cacheDump.put(mac_id,newMap);
								update(mac_id,newMap);
								break;
							}
						}else if(targetKey.equalsIgnoreCase("port")){
							if(!port.equals(targetValue)){
								UdpServerIKECIN.cacheDump.put(mac_id,newMap);
								update(mac_id,newMap);
								break;
							}
						}else if(targetKey.equalsIgnoreCase("status")){
							if(!status.equals(targetValue)){
								UdpServerIKECIN.cacheDump.put(mac_id,newMap);
								update(mac_id,newMap);
								break;
							}
						}
					}
			}else{
				insert(mac_id,newMap);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("Session closed...");

	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {

		System.out.println("Session created...");

		SocketAddress remoteAddress = session.getRemoteAddress();
		System.out.println(remoteAddress);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("Session idle...");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("Session Opened...");
		SocketAddress remoteAddress = session.getRemoteAddress();
		System.out.println(remoteAddress);
	}
	public void insert(String mac_id ,Map<String,String> map){
		Connection conn = getConn();
		UUID uuid = UUID.randomUUID();
		String ip = map.get("ip");
		String port = map.get("port");
		String status = map.get("status");
		String key_p = map.get("key_p");

		PreparedStatement pstmt = null;

		String sql = " insert zz_smartsocket (id,mac_id,ip,port,status,key_p) values ('"+uuid.toString()+"','"+mac_id+"','"+ip+"','"+port+"','"+status+"','"+key_p+"')";
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			conn.commit();
			UdpServerIKECIN.cacheDump.put(mac_id,map);

			conn.setAutoCommit(true);
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

	public void update(String mac_id ,Map<String,String> map ){
		String ip = map.get("ip");
		String port = map.get("port");
		String status = map.get("status");
		String key_p = map.get("key_p");
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		String sql = " update zz_smartsocket set ip = '"+ip+"', port = '"+port+"',status = '"+status+"',key_p='"+key_p+"' where mac_id ='"+mac_id+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
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
	public Connection getConn(){
		Properties pro = new Properties();
		try {
			pro.load(UdpServerIKECIN.class.getResourceAsStream("/dbconfig.properties"));
		} catch (IOException e) {
			System.out.println("未找到配置文件！！！");
		}
		String url = pro.getProperty("jdbc.url.platform");
		String user = pro.getProperty("jdbc.username.platform");
		String password = pro.getProperty("jdbc.password.platform");
		Connection conn = null;
		try {
			conn  = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}