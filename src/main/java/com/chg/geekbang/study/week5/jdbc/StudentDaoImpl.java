package com.chg.geekbang.study.week5.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * User: C.H.G
 * Date: 2021/9/14
 * Time: 下午2:31
 */
public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    private final static String TABLE_NAME="task_student";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void insert(String name, Integer age) {
        String sql = "INSERT INTO "+TABLE_NAME+"(name,age) value(?,?)";
        // 定义数组来存放SQL语句中的参数
        Object[] obj = new Object[] { name, age };
        // 执行添加操作，返回受SQL语句影响的条数
        this.jdbcTemplate.update(sql, obj);
    }

    @Override
    public Student getOne(Integer id) {
        return null;
    }

    @Override
    public void updateAge(Integer id, Integer age) {

    }

    @Override
    public List<Student> getList() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
