package com.chg.geekbang.study.week5.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: C.H.G
 * Date: 2021/9/16
 * Time: 下午3:28
 */
public class HikariConn {

    private short dbMaxConn = 10;
    private String dbHost = "192.168.41.162";
    private short dbPort = 3306;
    private String dbName = "btech_task";
    private String dbUsername = "root";
    private String dbPassword = "Cs8htxy3e2KJi52f";

    private Connection conn;

    private HikariDataSource dataSource;

    private HikariConn() {
        this.start();
    }

    public static HikariConn getInstance() {
        return HikariConn.Singleton.INSTANCE.getInstance();
    }

    public void start() {
        HikariConfig config = new HikariConfig();
        //classname
        config.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
        //url
        config.addDataSourceProperty("serverName",dbHost);
        //port
        config.addDataSourceProperty("port",dbPort);
        //databaseName
        config.addDataSourceProperty("databaseName",dbName);
        //username
        config.addDataSourceProperty("user",dbUsername);
        //password
        config.addDataSourceProperty("password",dbPassword);
        //自动commit
        config.setAutoCommit(true);
        //最大连接数
        config.setMaximumPoolSize(dbMaxConn);
        //超时时间
        config.setConnectionTimeout(8*60*60);
        //数据库连接检测
        config.setConnectionTestQuery("SELECT 1");
        dataSource = new HikariDataSource(config);
    }

    public boolean stop() throws SQLException{
        dataSource.close();
        return true;
    }

    public Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }

    private enum Singleton {
        INSTANCE;

        private final HikariConn conn;

        Singleton() {
            this.conn = new HikariConn();
        }

        public HikariConn getInstance() {
            return conn;
        } 
    }
}
