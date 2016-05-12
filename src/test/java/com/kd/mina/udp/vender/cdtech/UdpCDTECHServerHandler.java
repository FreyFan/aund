package com.kd.mina.udp.vender.cdtech;
import java.net.SocketAddress;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class UdpCDTECHServerHandler extends IoHandlerAdapter {

	private UdpServerCDTECH server;

	public UdpCDTECHServerHandler(UdpServerCDTECH server) {
		this.server = server;
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
		session.close(true);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		SocketAddress remoteAddress = session.getRemoteAddress();
		String expression = message.toString();
		System.out.println("[" + expression + "]");
		/*if (message instanceof IoBuffer) {
	        IoBuffer buffer = (IoBuffer) message;
	        String sendContent = "18 FE 34 A1 2B 0D 00 00 01 00";
	        byte aaByte []=  new byte[10];
            aaByte[0] =  (byte)0x18;
            aaByte[1] =  (byte) 0xFE;
            aaByte[2] =  (byte)0x34;
            aaByte[3] =  (byte)0xA1;
            aaByte[4] =  (byte)0x2B;
            aaByte[5] =  (byte)0x0D;
            aaByte[6] =  (byte)0x00;
            aaByte[7] =  (byte)0x00;
            aaByte[8] =  (byte)0x02;
            aaByte[9] =  (byte)0x00;
//	        byte[]b = sendContent.getBytes(Charset.forName("utf-8"));
	        IoBuffer ioBuffer = IoBuffer.allocate(aaByte.length,false);
//	        ioBuffer.put(b);
	        ioBuffer.put(aaByte);
	        ioBuffer.flip();

	        session.write(ioBuffer, remoteAddress);
	    }*/

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
}