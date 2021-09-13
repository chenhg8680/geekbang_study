package com.chg.geekbang.study.week5.springbean.case2;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: C.H.G
 * Date: 2021/9/13
 * Time: 下午5:03
 */
public class UserRole {
    private User user;
    private Role role;

    @Autowired
    public UserRole(User user,Role role){
        this.role = role;
        this.user = user;
    }
}
