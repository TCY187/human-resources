package com.iotek.model;

/**
 * Created by TCY on 2018/7/27.
 */
public class Manager {
    private Integer id;
    private String mname;
    private String mpass;

    public Manager() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpass() {
        return mpass;
    }

    public void setMpass(String mpass) {
        this.mpass = mpass;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", mname='" + mname + '\'' +
                ", mpass='" + mpass + '\'' +
                '}';
    }
}
