package com.chg.geekbang.study.week5.springbean.case1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * User: C.H.G
 * Date: 2021/9/13
 * Time: 下午5:02
 */

@Data
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
}
