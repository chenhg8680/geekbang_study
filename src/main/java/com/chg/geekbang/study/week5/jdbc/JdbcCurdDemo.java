package com.chg.geekbang.study.week5.jdbc;

import com.chg.geekbang.study.week5.springbean.case1.UserRole;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * User: C.H.G
 * Date: 2021/9/14
 * Time: 下午2:18
 */
public class JdbcCurdDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("week5-jdbc.xml");
        //获取jdbcTemplate实例
        JdbcTemplate jdbcTemplate=(JdbcTemplate) context.getBean("jdbcTemplate");

        query(jdbcTemplate);
    }

    public static void add(JdbcTemplate jdbcTemplate){
        //增
        String sql = "INSERT INTO task_student(name,age) value('test',1)";
        jdbcTemplate.update(sql);
    }

    public static void update(JdbcTemplate jdbcTemplate){
        //增
        String sql = "UPDATE task_student SET age=2 WHERE id=2";
        jdbcTemplate.update(sql);
    }

    public static void delete(JdbcTemplate jdbcTemplate){
        //增
        String sql = "DELETE FROM task_student WHERE id=1";
        jdbcTemplate.update(sql);
    }

    public static void query(JdbcTemplate jdbcTemplate){
        //增
        String sql = "SELECT * FROM task_student";
        List<Student> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(list);
    }
}
