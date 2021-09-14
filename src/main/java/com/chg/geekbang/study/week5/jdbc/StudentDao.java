package com.chg.geekbang.study.week5.jdbc;

import java.util.List;

/**
 * Author: C.H.G
 * User: C.H.G
 * Date: 2021/9/14
 * Time: 下午2:21
 */
public interface StudentDao {

    public void insert(String name,Integer age);

    public Student getOne(Integer id);

    public void updateAge(Integer id,Integer age);

    public List<Student> getList();

    public void delete(Integer id);
}
