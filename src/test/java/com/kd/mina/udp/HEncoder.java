package com.kd.mina.udp;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class HEncoder extends ProtocolEncoderAdapter {

	private final Charset charset;

	public HEncoder(Charset charset) {
		this.charset = charset;

	}

	@Override
	public void encode(IoSession arg0, Object arg1, ProtocolEncoderOutput arg2)
			throws Exception {

		CharsetEncoder ce = charset.newEncoder();

		PlayerAccount_Entity paEntity = (PlayerAccount_Entity) arg1;
		String name = paEntity.getName(); 

		IoBuffer buffer = IoBuffer.allocate(100).setAutoExpand(true);
		buffer.putString(name, ce); 
		buffer.flip();
		arg2.write(buffer);

	}}
