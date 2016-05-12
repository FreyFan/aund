package com.kd.mina.udp;

import java.net.SocketAddress;
import java.util.Collection;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
public class UdpServerHandler extends IoHandlerAdapter {
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
		session.close(true);
	}

	public void messageReceived(IoSession session, Object message) throws Exception {

		String expression = message.toString();
		System.out.println("test received[" + expression + "]");
	}

	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("Session closed...");

	}

	public void sessionCreated(IoSession session) throws Exception {

		System.out.println("Session created...");

		SocketAddress remoteAddress = session.getRemoteAddress();
		System.out.println(remoteAddress);
	}

	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("Session idle...");
	}

	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("Session Opened...");
		SocketAddress remoteAddress = session.getRemoteAddress();
		System.out.println(remoteAddress);
	}
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		System.out.println("发送数据---------------------------------------");
//		Collection<IoSession> sessions = session.getService().getManagedSessions().values();
//		// 向所有客户端发送数据
//        for (IoSession sess : sessions) {
//		session.write("18 FE 34 A1 2B 0D 00 00 02 00");
//        }
//		 byte aaByte []=  new byte[10];
//	        aaByte[0] =  (byte)0x18;
//	        aaByte[1] =  (byte) 0xfe;
//	        aaByte[2] =  (byte)0x34;
//	        aaByte[3] =  (byte)0xA1;
//	        aaByte[4] =  (byte)0x2B;
//	        aaByte[5] =  (byte)0x0D;
//	        aaByte[6] =  (byte)0x00;
//	        aaByte[7] =  (byte)0x00;
//	        aaByte[8] =  (byte)0x02;
//	        aaByte[9] =  (byte)0x00;
////	        aaByte[10] =  (byte)0x00;
//	        session.write(aaByte);
	}
}