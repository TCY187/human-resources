package com.iotek.model;

import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/8/2.
 */
public class Cul {
    private Integer id;
    private String theme;
    private String content;
    private Date begintime;
    private Date endtime;
    private String address;
    private Integer state;
    private Date issuetime;
    private List<Emp> empList;

    public Cul() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getIssuetime() {
        return issuetime;
    }

    public void setIssuetime(Date issuetime) {
        this.issuetime = issuetime;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Cul{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", content='" + content + '\'' +
                ", begintime=" + begintime +
                ", endtime=" + endtime +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", issuetime=" + issuetime +
                ", empList=" + empList +
                '}';
    }
}
