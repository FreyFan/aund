package com.kd.mina.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/**
 * @author ZYWANG
 *
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket  server = new DatagramSocket(12188);
        byte[] recvBuf = new byte[100];
        DatagramPacket recvPacket 
            = new DatagramPacket(recvBuf , recvBuf.length);
        int i = 0;
        while(true){
        	System.out.println(i);
        	i++;
        	server.receive(recvPacket);
            String recvStr = new String(recvPacket.getData() , 0 , recvPacket.getLength());
            System.out.println("Hello World!" + recvStr);
            int port = recvPacket.getPort();
            InetAddress addr = recvPacket.getAddress();
           
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
            
            DatagramPacket sendPacket  = new DatagramPacket(aaByte , aaByte.length , addr , port );
            server.send(sendPacket);
        }
    }
}
