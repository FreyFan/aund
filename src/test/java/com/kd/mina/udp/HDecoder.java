package com.kd.mina.udp;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class HDecoder extends CumulativeProtocolDecoder {
	private final Charset charset;

	public HDecoder(Charset charset) {
		this.charset = charset;

	}

	@Override
	protected boolean doDecode(IoSession arg0, IoBuffer arg1,
			ProtocolDecoderOutput arg2)  {
		CharsetDecoder cd;
		String name;
		try {
			cd = charset.newDecoder();
			name = arg1.getString(cd);
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		PlayerAccount_Entity paEntity = new PlayerAccount_Entity();
		paEntity.setName(name);

		arg2.write(paEntity);
		return true;
	}
}
