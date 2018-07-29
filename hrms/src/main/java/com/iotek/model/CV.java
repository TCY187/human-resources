package com.iotek.model;

import java.util.Date;

/**
 * Created by TCY on 2018/7/25.
 */
public class CV {
    private Integer id;
    private String uname;
    private String sex;
    private Date birth;
    private String bp;
    private String edu;
    private String major;
    private String email;
    private String phone;
    private String school;
    private String hobg;
    private String selfeval;
    private User user;
    private String cvname;
    private String cardno;
    private String skill;
    private String zp;

    public CV() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getHobg() {
        return hobg;
    }

    public void setHobg(String hobg) {
        this.hobg = hobg;
    }

    public String getSelfeval() {
        return selfeval;
    }

    public void setSelfeval(String selfeval) {
        this.selfeval = selfeval;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCvname() {
        return cvname;
    }

    public void setCvname(String cvname) {
        this.cvname = cvname;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getZp() {
        return zp;
    }

    public void setZp(String zp) {
        this.zp = zp;
    }

    @Override
    public String toString() {
        return "CV{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", bp='" + bp + '\'' +
                ", edu='" + edu + '\'' +
                ", major='" + major + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", school='" + school + '\'' +
                ", hobg='" + hobg + '\'' +
                ", selfeval='" + selfeval + '\'' +
                ", user=" + user +
                ", cvname='" + cvname + '\'' +
                ", cardno='" + cardno + '\'' +
                ", skill='" + skill + '\'' +
                ", zp='" + zp + '\'' +
                '}';
    }
}
