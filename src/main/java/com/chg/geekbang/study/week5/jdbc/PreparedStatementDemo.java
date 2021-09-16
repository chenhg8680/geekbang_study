package com.chg.geekbang.study.week5.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * User: C.H.G
 * Date: 2021/9/16
 * Time: 下午2:13
 */
public class PreparedStatementDemo {
    public static void main(String[] args) throws Exception{
        PreparedStatementDemo.add();
    }

    public static void add() throws SQLException {
        Connection conn = MysqlConn.getInstance().getConn();
        PreparedStatement ps = null;
        String sql = "INSERT INTO task_student(name,age) value (?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,"test22222");
            ps.setInt(2,1);
            boolean dbRes = ps.execute();

            System.out.println(dbRes);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != ps) {
                ps.close();
            }
        }
    }

    public static void update() throws Exception{
        Connection conn = MysqlConn.getInstance().getConn();
        PreparedStatement ps = null;
        String sql = "UPDATE task_student SET age=? WHERE id=?;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,100);
            ps.setInt(2,2);
            boolean dbRes = ps.execute();
            System.out.println(dbRes);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != ps) {
                ps.close();
            }
        }
    }

    public static void delete()throws Exception{

        Connection conn = MysqlConn.getInstance().getConn();
        Statement st = null;
        String sql = "DELETE FROM task_student WHERE id=2";
        try {
            st = conn.createStatement();
            st.execute(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != st) {
                st.close();
            }
        }
    }

    public static void query() throws Exception{
        Connection conn = MysqlConn.getInstance().getConn();
        Statement statement = null;
        String sql = "SELECT * FROM task_student";
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println(rs.getFetchSize());
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("name");
                System.out.println("查询到数据： id [" + id + "] name [" + username + "]");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (null != statement) {
                statement.close();
            }
            if (null != conn) {
                conn.close();
            }
        }
    }
}
