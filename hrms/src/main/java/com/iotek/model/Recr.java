package com.iotek.model;

import java.util.Date;

/**
 * Created by TCY on 2018/7/25.
 */
public class Recr {
    private Integer id;
    private Position position;
    private Depa depa;
    private String desc;
    private Integer num;
    private Integer state;
    private Date time;

    public Recr() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Depa getDepa() {
        return depa;
    }

    public void setDepa(Depa depa) {
        this.depa = depa;
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
                ", position=" + position +
                ", depa=" + depa +
                ", desc='" + desc + '\'' +
                ", num=" + num +
                ", state=" + state +
                ", time=" + time +
                '}';
    }
}
