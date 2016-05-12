package com.kd.mina.udp;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilterUdp extends LoggingFilter {
	Logger logger  = LoggerFactory.getLogger(LoggingFilterUdp.class);;
	@Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        LogLevel messageReceivedLevel = LogLevel.INFO;
		log(messageReceivedLevel , "RECEIVED: {}", message);
        nextFilter.messageReceived(session, message);
//        Thread.sleep(10000);
        System.out.println("----------------向客户端发送数据----------------");
//        Byte messageByte =  new  Byte("18FE34A12B0D0000040000");
        byte aaByte []=  new byte[10];
        aaByte[0] =  (byte)0x18;
        aaByte[1] =  (byte) 0xfe;
        aaByte[2] =  (byte)0x34;
        aaByte[3] =  (byte)0xA1;
        aaByte[4] =  (byte)0x2B;
        aaByte[5] =  (byte)0x0D;
        aaByte[6] =  (byte)0x00;
        aaByte[7] =  (byte)0x00;
        aaByte[8] =  (byte)0x02;
        aaByte[9] =  (byte)0x00;
//        aaByte[10] =  (byte)0x00;
        session.write(aaByte);
        
        
    }
	private void log(LogLevel eventLevel, String message, Object param) {
        switch (eventLevel) {
        case TRACE:
            logger.trace(message, param);
            return;
        case DEBUG:
            logger.debug(message, param);
            return;
        case INFO:
            logger.info(message, param);
            return;
        case WARN:
            logger.warn(message, param);
            return;
        case ERROR:
            logger.error(message, param);
            return;
        default:
            return;
        }
    }
}
