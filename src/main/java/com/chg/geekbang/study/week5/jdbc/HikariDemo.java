package com.chg.geekbang.study.week5.jdbc;

/**
 * User: C.H.G
 * Date: 2021/9/16
 * Time: 下午3:27 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;


public class HikariDemo {

    public static void main(String[] args) throws Exception{
        psTrans();
    }

    private static void psTrans() throws Exception{
        Connection conn = HikariConn.getInstance().getConn();

        PreparedStatement ps = null;
        String sql = "INSERT INTO task_student(name,age) values (?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            for(int i=0;i<10;i++){
                ps.setString(1,"CHG-Hikari"+i);
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
}
