package com.chg.geekbang.study.week5.springbean.case2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Required;

/**
 * User: C.H.G
 * Date: 2021/9/13
 * Time: 下午5:02
 */

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;

    @Required
    public void setId(Integer id) {
        this.id = id;
    }
}
