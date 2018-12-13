package com.somnus.androiddagger2demo.bean;

/**
 * Created by Somnus on 2017/6/28.
 *
 * @Description:
 */

public class User {
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

}
