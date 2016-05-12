package com.kd.mina.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class SendIP {

	public static void main(String args[]) {
		new SendIP().lanchApp();
	 }
	
	private void lanchApp(){
		SendThread th=new SendThread();
		th.start();
	}
	
	
	private class SendThread extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					BroadcastIP();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		private void BroadcastIP()throws Exception{
			 DatagramSocket dgSocket=new DatagramSocket();
			 byte aaByte []=  new byte[11];
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
	            aaByte[10] = (byte)0x00;
			  DatagramPacket dgPacket=new DatagramPacket(aaByte,aaByte.length,InetAddress.getByName("255.255.255.255"),12188);
			  dgSocket.send(dgPacket);
			  dgSocket.close();
			  System.out.println("send message is ok.");
		}
	}
	
}
