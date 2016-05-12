package com.kd.mina;

import org.apache.mina.transport.socket.SocketAcceptor;

public class SocketAcceptorFactory {
	
	private static SocketAcceptor socketAcceptor;

	public static SocketAcceptor getSocketAcceptor() {
		return socketAcceptor;
	}

	public static void setSocketAcceptor(SocketAcceptor socketAcceptor) {
		SocketAcceptorFactory.socketAcceptor = socketAcceptor;
	}

}
