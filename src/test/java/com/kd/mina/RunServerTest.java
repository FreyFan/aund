package com.kd.mina;

import java.util.Collection;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.SocketAcceptor;

public class RunServerTest {
	
	public static void main(String[] args) {
	
		SocketAcceptor socketAcc = SocketAcceptorFactory.getSocketAcceptor();
		Collection<IoSession> sessions = socketAcc.getManagedSessions().values();
        // 向所有客户端发送数据
        for (IoSession sess : sessions) {
            sess.write("server send kkk");
        }
	}

}
