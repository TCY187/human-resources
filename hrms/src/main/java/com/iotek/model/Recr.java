package com.iotek.model;

import java.util.Date;

/**
 * Created by TCY on 2018/7/25.
 */
public class Recr {
    private Integer id;
    private String position;
    private String depart;
    private Double sal;
    private String desc;
    private Integer num;
    private Integer state;
    private Date time;

    public Recr() {
    }

    public Recr(Integer id, String position, String depart, Double sal, String desc, Integer num, Integer state, Date time) {
        this.id = id;
        this.position = position;
        this.depart = depart;
        this.sal = sal;
        this.desc = desc;
        this.num = num;
        this.state = state;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Recr{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", depart='" + depart + '\'' +
                ", sal=" + sal +
                ", desc='" + desc + '\'' +
                ", num=" + num +
                ", state=" + state +
                ", time=" + time +
                '}';
    }
}
