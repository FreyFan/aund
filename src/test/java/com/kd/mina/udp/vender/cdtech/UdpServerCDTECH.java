package com.kd.mina.udp.vender.cdtech;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;

public class UdpServerCDTECH {
	private static final long serialVersionUID = 1L;

	public static final int PORT = 12188;
	public static List<String> devList = new ArrayList<String>();
	private static NioDatagramAcceptor acceptor;
	private static byte[] buffer = new byte[1024];
	private DatagramSocket ds = null;    
	private DatagramPacket packet = null;
	public UdpServerCDTECH() throws IOException {

		acceptor = new NioDatagramAcceptor();
		acceptor.setHandler(new UdpCDTECHServerHandler(this));

		Executor threadPool = Executors.newCachedThreadPool();
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		chain.addLast("logger", new LoggingFilter());
		// chain.addLast("codec", new ProtocolCodecFilter(new
		// TextLineCodecFactory(Charset.forName("UTF-8"))));
		chain.addLast("threadPool", new ExecutorFilter(threadPool));

		DatagramSessionConfig dcfg = acceptor.getSessionConfig();
		dcfg.setReadBufferSize(4096);// 设置接收最大字节默认2048
		dcfg.setMaxReadBufferSize(65536);
		dcfg.setReceiveBufferSize(1024);// 设置输入缓冲区的大小
		dcfg.setSendBufferSize(1024);// 设置输出缓冲区的大小
		dcfg.setReuseAddress(true);// 设置每一个非主监听连接的端口可以重用

		acceptor.bind(new InetSocketAddress(PORT));
		System.out.println("CDTECH UDPServer listening on port " + PORT);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

			sendMessage();

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

	public static void sendMessage() {
		//发送数据的套接字变量
        DatagramSocket ds = null;
        //UDP的数据包变量
        DatagramPacket dp = null;
        try{

        //实例化UDP的套接字,端口号为9999,UDP套接字绑定的端口
        ds = new DatagramSocket();
        //需要发送的数据
        byte aaByte []=  new byte[10];
        aaByte[0] =  (byte)0x18;
        aaByte[1] =  (byte)0xFE;
        aaByte[2] =  (byte)0x34;
        aaByte[3] =  (byte)0xA1;
        aaByte[4] =  (byte)0x2B;
        aaByte[5] =  (byte)0x0D;
        aaByte[6] =  (byte)0x00;
        aaByte[7] =  (byte)0x00;
        aaByte[8] =  (byte)0x01;
        aaByte[9] =  (byte)0x00;
        //指定需要发送的数据内容,数据长度,目的IP和目的端口号
        dp = new DatagramPacket(aaByte,aaByte.length,InetAddress.getByName("192.168.1.100"),1025);
        //发送数据
        ds.send(dp);
        //关闭
        ds.close();
        }catch(Exception e ){
        	e.printStackTrace();
        }
	}

	public static void main(String[] args) throws IOException {
		new UdpServerCDTECH();
	}
}