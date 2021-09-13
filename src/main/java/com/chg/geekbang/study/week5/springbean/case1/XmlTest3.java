package com.chg.geekbang.study.week5.springbean.case1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: C.H.G
 * Date: 2021/9/13
 * Time: 下午5:27
 */
public class XmlTest3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("week5-case1-3.xml");
        UserRole userRole = (UserRole) context.getBean("userRole");
        System.out.println(userRole.toString());
    }
}
