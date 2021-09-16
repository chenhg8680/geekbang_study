package com.chg.geekbang.study.week5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * User: C.H.G
 * Date: 2021/9/15
 * Time: 上午10:36
 */
public class MysqlConn {
    public static final String URL = "jdbc:mysql://192.168.41.162:3306/btech_task";
    public static final String USERNAME = "root";
    public static final String PASSWD = "Cs8htxy3e2KJi52f";

    private Connection connection;

    public MysqlConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.MysqlDataSource");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWD);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    public static MysqlConn getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public Connection getConn() {
        return connection;
    }

    private enum Singleton {
        INSTANCE;
        private final MysqlConn conn;
        Singleton() {
            this.conn = new MysqlConn();
        }
        public MysqlConn getInstance() {
            return conn;
        }
    }
}
