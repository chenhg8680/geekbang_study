package com.chg.geekbang.study.week5.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User: C.H.G
 * Date: 2021/9/14
 * Time: 下午2:23
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Student { 
    private Integer id;
    private String name;
    private Integer age;
}
