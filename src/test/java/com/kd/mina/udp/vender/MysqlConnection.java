package com.kd.mina.udp.vender;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by fanchengwei on 15/12/25.
 */
public class MysqlConnection {
    public static Connection getConn(){
        Properties pro = new Properties();
        try {
            pro.load(MysqlConnection.class.getResourceAsStream("/dbconfig.properties"));
        } catch (IOException e) {
            System.out.println("未找到配置文件！！！");
        }
        String url = pro.getProperty("jdbc.url.platform");
        String user = pro.getProperty("jdbc.username.platform");
        String password = pro.getProperty("jdbc.password.platform");
        Connection conn = null;
        try {
            conn  = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
