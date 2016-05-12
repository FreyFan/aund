package com.kd.mina;
 
import java.util.Scanner;
 
/**
 * <b>function:</b> 运行客户端程序
 * @author hoojo
 * @createDate 2012-6-29 下午07:36:44
 * @file RunClient.java
 * @package com.hoo.mina.client.main
 * @project ApacheMiNa
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class RunClientTest {
 
    public static void main(String[] args) {
        MinaClient client = new MinaClient();
        if (client.connect()) {
            client.send("连接服务器成功！");
//            Scanner scanner = new Scanner(System.in);
//            while (scanner.hasNext()) {
//                client.send(scanner.next());
//            }
            client.send("hello yangmeng------------");
        }
    }
}