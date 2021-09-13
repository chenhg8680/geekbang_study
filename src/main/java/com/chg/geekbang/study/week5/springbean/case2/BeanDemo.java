package com.chg.geekbang.study.week5.springbean.case2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: C.H.G
 * Date: 2021/9/13
 * Time: 下午4:13
 */
public class BeanDemo {

        public static void main(String[] args) {

            ApplicationContext context = new ClassPathXmlApplicationContext("week5-case2.xml");

            User user = (User) context.getBean("user");
            System.out.println(user);

            UserRole userRole = (UserRole) context.getBean("userRole");
            System.out.println(userRole);

        }
}
