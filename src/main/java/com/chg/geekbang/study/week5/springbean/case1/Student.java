package com.chg.geekbang.study.week5.springbean.case1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User: C.H.G
 * Date: 2021/9/8
 * Time: 下午4:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;

    public void print() {
        System.out.println(this.getName());

    }
}
