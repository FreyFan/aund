package com.kd.mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinaServerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static Logger log = LoggerFactory.getLogger(MinaServerServlet.class);

	public void  init() throws ServletException {
	    //
		log.error("socket server start:-----------------------------------");
		MinaServerServlet server = new MinaServerServlet();
        server.start();
	}
	
    private SocketAcceptor acceptor;
    
    public MinaServerServlet() {
        // 创建非阻塞的server端的Socket连接
        acceptor = new NioSocketAcceptor();
    }
    
    public boolean start() {
        DefaultIoFilterChainBuilder filterChain = acceptor.getFilterChain();
        // 添加编码过滤器 处理乱码、编码问题
        filterChain.addLast("codec", new ProtocolCodecFilter(new CharsetCodecFactory()));
        
        /*LoggingFilter loggingFilter = new LoggingFilter();
        loggingFilter.setMessageReceivedLogLevel(LogLevel.INFO);
        loggingFilter.setMessageSentLogLevel(LogLevel.INFO);
        // 添加日志过滤器
        filterChain.addLast("loger", loggingFilter);*/
        
        // 设置核心消息业务处理器
        acceptor.setHandler(new ServerMessageHandler());
        // 设置session配置，30秒内无操作进入空闲状态
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 30);
        
        try {
            // 绑定端口3456
            acceptor.bind(new InetSocketAddress(3456));
            // 写入内存
            SocketAcceptorFactory.setSocketAcceptor(acceptor);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

	public SocketAcceptor getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(SocketAcceptor acceptor) {
		this.acceptor = acceptor;
	}

	public static void main(String[] args) {
        MinaServer server = new MinaServer();
        server.start();
    }
}
