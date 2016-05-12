package com.kd.mina.udp.vender.ikecin;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;


import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class MyTextLineCodecDecoder implements ProtocolDecoder {

    private Charset charset = Charset.forName("UTF-8");

    IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);

    public static byte [] ioBufferToByte(Object message)
    {
        if (!(message instanceof IoBuffer))
        {
            return null;
        }
        IoBuffer ioBuffer = (IoBuffer)message;
        byte[] b = new byte[ioBuffer.limit()];
        ioBuffer.get(b);
        return b;
    }

    @Override
    public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
            throws Exception {
        // TODO Auto-generated method stub

        while (in.hasRemaining()) {
            byte b = in.get();
            switch (b){
                case '\r':
                    System.out.println("rrrr");
                    break;
                case '\n':
                    System.out.println("nnnnn");
                    buf.flip();
                    String msg = buf.getString(charset.newDecoder());
                    System.out.println("Msg:"+msg);
                    out.write(msg);
                    break;
                default:
                    System.out.println("b:"+b);
                    buf.put(b);
            }

        }


    }

    @Override
    public void dispose(IoSession arg0) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1)
            throws Exception {
        // TODO Auto-generated method stub

    }
}

