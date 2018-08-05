package com.iotek.model;

import java.util.Date;

/**
 * Created by TCY on 2018/8/3.
 */
public class Attendance {
    private Integer id;
    private Emp emp;
    private Date time;//日期
    private Date ontime;//上班时间
    private Date offtime;//下班时间
    private Integer state;//0 上班打卡下班未打，1 上下班正常打卡，2 超过三小时导致旷工

    public Attendance() {
    }

    public Attendance(Emp emp, Date time, Date ontime, Date offtime, Integer state) {
        this.emp = emp;
        this.time = time;
        this.ontime = ontime;
        this.offtime = offtime;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getOntime() {
        return ontime;
    }

    public void setOntime(Date ontime) {
        this.ontime = ontime;
    }

    public Date getOfftime() {
        return offtime;
    }

    public void setOfftime(Date offtime) {
        this.offtime = offtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", emp=" + emp +
                ", time=" + time +
                ", ontime=" + ontime +
                ", offtime=" + offtime +
                ", state=" + state +
                '}';
    }
}
