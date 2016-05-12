package com.kd.mina.udp.vender.ikecin;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UdpServerIKECINTest{
	private static final long serialVersionUID = 1L;

	public static final int PORT = 60002;//ikecin默认端口60002
	public static List<String> devList;
	private static NioDatagramAcceptor acceptor;
	private static byte[] buffer = new byte[1024];
	private DatagramSocket ds = null;
	private DatagramPacket packet = null;
	static {
		devList = new ArrayList<String>();
	}
	public UdpServerIKECINTest() throws IOException {
		acceptor = new NioDatagramAcceptor();
		acceptor.setHandler(new UdpIKECINServerHandlerTest(this));

		Executor threadPool = Executors.newCachedThreadPool();

		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		LoggingFilter loggingFilter = new LoggingFilter();
		loggingFilter.setSessionClosedLogLevel(LogLevel.INFO);
		loggingFilter.setSessionCreatedLogLevel(LogLevel.INFO);
		loggingFilter.setSessionOpenedLogLevel(LogLevel.INFO);

		chain.addLast("logger", loggingFilter);
		/**
		 * 注释以下2行代码解决handler message receive 由于"编码问题"无法获取客户端发送的信息

		 chain.addLast("codec", new ProtocolCodecFilter(new
				 TextLineCodecFactory(Charset.forName("UTF-8"))));*/

//		acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new MyTextLineCodecDecoder()));
//		chain.addLast("threadPool", new ExecutorFilter(threadPool));
		DatagramSessionConfig dcfg = acceptor.getSessionConfig();
		dcfg.setReadBufferSize(4096);// 设置接收最大字节默认2048
		dcfg.setMaxReadBufferSize(65536);
		dcfg.setReceiveBufferSize(1024);// 设置输入缓冲区的大小
		dcfg.setSendBufferSize(1024);// 设置输出缓冲区的大小
		dcfg.setReuseAddress(true);// 设置每一个非主监听连接的端口可以重用

		acceptor.bind(new InetSocketAddress(PORT));
		System.out.println("IKECIN UDPServer listening on port " + PORT);

		sendMessage(UdpServerIKECINTest.devList);
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
        ds = new DatagramSocket();
		/**
		 * 要发送的数据 设备关闭
		 * {"sn":"xxxxx","p_w":"123456","k_close":true,"seq":由APP端递增发送}
		 */
			for (int i = 0; i < devList.size(); i++) {

			}
		String dev_id ="";
		String closeOrder = "{'sn':'100610000012','k_close':true,'p_w':'123456'}";
		System.out.println("closeOrder:"+closeOrder);
		byte[] aaByte = closeOrder.toString().getBytes();
        //指定需要发送的数据内容,数据长度,目的IP和目的端口号
        dp = new DatagramPacket(aaByte,aaByte.length,InetAddress.getByName("192.168.1.102"),60002);
        //发送数据
        ds.send(dp);
        //关闭
        ds.close();
			UdpServerIKECINTest.devList.clear();
        }catch(Exception e ){
        	e.printStackTrace();
        }
	}

	public static void main(String[] args) throws IOException {
		new UdpServerIKECINTest();
	}
}