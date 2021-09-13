package com.chg.geekbang.study.week5.springbean.case1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User: C.H.G
 * Date: 2021/9/13
 * Time: 下午5:03
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UserRole {
    private User user;
    private Role role;
}
