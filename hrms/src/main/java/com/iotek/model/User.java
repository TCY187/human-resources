package com.iotek.model;

import java.util.List;

/**
 * Created by TCY on 2018/7/25.
 */
public class User {
    private Integer id;
    private String name;
    private String pass;
    private List<CV> cvList;

    public User() {
    }

    public User(Integer id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<CV> getCvList() {
        return cvList;
    }

    public void setCvList(List<CV> cvList) {
        this.cvList = cvList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", cvList=" + cvList +
                '}';
    }
}
