package com.chg.geekbang.study.week5.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * User: C.H.G
 * Date: 2021/9/14
 * Time: 下午5:38
 */
public class JdbcPrepareStatementDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("week5-jdbc.xml");
        //获取jdbcTemplate实例
        JdbcTemplate jdbcTemplate=(JdbcTemplate) context.getBean("jdbcTemplate");

        add(jdbcTemplate);
        batchAdd(jdbcTemplate);
        query(jdbcTemplate);


    }

    public static void add(JdbcTemplate jdbcTemplate){
        //增
        String sql = "INSERT INTO task_student(name,age) value(?,?)";

        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, "托尔斯泰");
                preparedStatement.setInt(2,1);
            }
        });
    }

    public static void batchAdd(JdbcTemplate jdbcTemplate){

        List<HashMap<String,Object>> params = new ArrayList<>();
        HashMap<String,Object> one = new HashMap();
        one.put("name","abc");
        one.put("age",1);
        params.add(one);
        HashMap<String,Object> one2 = new HashMap();
        one2.put("name","abc");
        one2.put("age",1);
        params.add(one2);

        //增
        String sql = "INSERT INTO task_student(name,age) values(?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1,params.get(i).get("name").toString());
                    ps.setInt(2,(Integer) params.get(i).get("age"));
            }

            @Override
            public int getBatchSize() {
                return params.size();
            }
        });
    }

    public static void update(JdbcTemplate jdbcTemplate){
        //增
        String sql = "UPDATE task_student SET age=? WHERE id=?";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2,1);
            }
        });
    }

    public static void delete(JdbcTemplate jdbcTemplate){
        //增
        String sql = "DELETE FROM task_student WHERE id=1";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, 1);
            }
        });
    }

    public static void query(JdbcTemplate jdbcTemplate){
        //增
        String sql = "SELECT * FROM task_student";

        List<Student> list =  jdbcTemplate.query(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
            }
        },new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(list);
    }
}
