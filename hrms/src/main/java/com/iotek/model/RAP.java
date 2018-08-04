package com.iotek.model;

import java.util.Date;

/**
 * Created by TCY on 2018/8/3.
 */
public class RAP {
    private Integer id;
    private Date time;
    private Double money;
    private Emp emp;
    private String intro;
    private Integer state;//0 迟到，1 早退，2 加班，3 结算错误，4 其他

    public RAP() {
    }

    public RAP(Date time, Double money, Emp emp, String intro) {
        this.time = time;
        this.money = money;
        this.emp = emp;
        this.intro = intro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RAP{" +
                "id=" + id +
                ", time=" + time +
                ", money=" + money +
                ", emp=" + emp +
                ", intro='" + intro + '\'' +
                ", state=" + state +
                '}';
    }
}
