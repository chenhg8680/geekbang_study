package com.chg.geekbang.study.week5.springbean.case1;

import lombok.Data;

import java.util.List;

/**
 * User: C.H.G
 * Date: 2021/9/8
 * Time: 下午4:28
 */
@Data
public class Klass {
    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }
}
