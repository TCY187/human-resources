package com.iotek.model;

import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
public class Depa {
    private Integer id;
    private String dname;
    private Date time;
    private List<Position> positionList;

    public Depa() {
    }

    public Depa(Integer id, String dname, Date time) {
        this.id = id;
        this.dname = dname;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    @Override
    public String toString() {
        return "Depa{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", time=" + time +
                '}';
    }
}
