package com.kd.mina.udp.vender.ikecin;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.SocketAddress;

public class UdpIKECINServerHandlerTest extends IoHandlerAdapter {

	private UdpServerIKECINTest server;

	public UdpIKECINServerHandlerTest(UdpServerIKECINTest server) {
		this.server = server;
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
		session.close(true);
	}

	public void messageReceived1(IoSession session, Object message) throws Exception {
		SocketAddress remoteAddress = session.getRemoteAddress();
		String expression = message.toString();

		System.out.println(expression);
	}

	public void messageReceived(IoSession session, Object message) throws Exception {
		SocketAddress remoteAddress = session.getRemoteAddress();

		String expression = message.toString();
		IoBuffer ioBuffer = (IoBuffer)message;
		byte[] b = new byte[ioBuffer.limit()];
		ioBuffer.get(b);
		for (byte aB : b) {
			String hex = Integer.toHexString(aB & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
		}
		String UDPMsg = new String(b, 12, b.length - 12).trim();

		if (UDPMsg.isEmpty()) {
			return;
		}


		final JSONObject result;
		try {
			result = new JSONObject(UDPMsg);
			String macid = result.getString("sn");
			String key_v = result.getInt("key_V")+"";
			String key_i = result.getInt("key_I")+"";
			String key_p = result.getInt("key_P")+"";
			String e_stats = result.getInt("E_stats")+"";
			String[] addr = remoteAddress.toString().split(":");
			String ip = addr[0].substring(1,addr[0].length());
			String port = addr[1];
			System.out.println("macid:"+macid);
			System.out.println("key_v:"+key_v);
			System.out.println("key_i:"+key_i);
			System.out.println("key_p:"+key_p);
			System.out.println("e_stats:"+e_stats);
			System.out.println("ip:"+ip);
			System.out.println("port:"+port);

		} catch (JSONException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(result.toString());
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