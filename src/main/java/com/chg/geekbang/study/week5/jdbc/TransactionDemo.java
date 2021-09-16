package com.chg.geekbang.study.week5.jdbc;

import java.sql.*;

/**
 * User: C.H.G
 * Date: 2021/9/16
 * Time: 下午2:53
 */
public class TransactionDemo {
    public static void main(String[] args) throws Exception{
        TransactionDemo.statementTrans();
    }

    public static void psTrans() throws SQLException {
        Connection conn = MysqlConn.getInstance().getConn();
        PreparedStatement ps = null;
        String sql = "INSERT INTO task_student(name,age) values (?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            for(int i=0;i<10;i++){
                ps.setString(1,"CHG"+i);
                ps.setInt(2,100+i);
                ps.addBatch();
            }

            int[] dbRes = ps.executeBatch();
            System.out.println(dbRes);

            conn.commit();

        }catch (Exception e) {
            System.out.println("处理失败，事务回滚");
            conn.rollback();
            e.printStackTrace();
        }finally {
            if(null != ps) {
                ps.close();
            }
        }
    }

    public static void statementTrans() throws Exception{
        Connection conn = MysqlConn.getInstance().getConn();
        Statement st = null;
        //String sql1 = "UPDATE task_student SET age1=10000 WHERE id=1;";
        String sql1 = "UPDATE task_student SET age=10000 WHERE id=1;";
        String sql2 = "INSERT INTO task_student(name,age) values ('TRANS2',100)";
        try {
            conn.setAutoCommit(false);

            st = conn.createStatement();
            st.addBatch(sql1);
            st.addBatch(sql2);

            int[] dbRes = st.executeBatch();
            System.out.println(dbRes);

            conn.commit();
        }catch (Exception e) {
            System.out.println("执行失败，事务回滚");
            conn.rollback();
            e.printStackTrace();
        }finally {
            if(null != st) {
                st.close();
            }
        }
    }
}
