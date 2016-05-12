package com.kd.mina.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinaUdpServerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int PORT = 12188;
	
	private final static Logger log = LoggerFactory.getLogger(MinaUdpServerServlet.class);

	public void  init() throws ServletException {
		log.error("socket server start:-----------------------------------");
		MinaUdpServerServlet server = new MinaUdpServerServlet();
        server.start();
	}
	
    private NioDatagramAcceptor acceptor;
    
    public MinaUdpServerServlet() {
        // 创建非阻塞的server端的Socket连接
        acceptor = new NioDatagramAcceptor();
    }
    
    public boolean start() {
    	NioDatagramAcceptor acceptor = new NioDatagramAcceptor();
    	acceptor.setHandler(new UdpServerHandler());
	
		Executor threadPool = Executors.newCachedThreadPool();
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		chain.addLast("logger", new LoggingFilterUdp());
		chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		chain.addLast("threadPool", new ExecutorFilter(threadPool));
	
		DatagramSessionConfig dcfg = acceptor.getSessionConfig();
		dcfg.setReadBufferSize(4096);// 设置接收最大字节默认2048
		dcfg.setMaxReadBufferSize(65536);
		dcfg.setReceiveBufferSize(1024);// 设置输入缓冲区的大小
		dcfg.setSendBufferSize(1024);// 设置输出缓冲区的大小
		dcfg.setReuseAddress(true);// 设置每一个非主监听连接的端口可以重用
		try {
			acceptor.bind(new InetSocketAddress(PORT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		System.out.println("UDPServer listening on port " + PORT);
		return true;
	}


	public NioDatagramAcceptor getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(NioDatagramAcceptor acceptor) {
		this.acceptor = acceptor;
	}

	public static void main(String[] args) {
		MinaUdpServerServlet server = new MinaUdpServerServlet();
		server.start();
    }
}
