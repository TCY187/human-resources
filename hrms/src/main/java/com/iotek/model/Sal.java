package com.iotek.model;

import java.util.Date;

/**
 * Created by TCY on 2018/8/3.
 */
public class Sal {
    private Integer id;
    private Date monthtime;
    private Emp emp;
    private Double jsal;//基本薪资
    private Double pfsal;//绩效薪资
    private Double oversal;//加班薪资
    private Double rapsal;//奖惩薪资
    private Double sssal;//社保薪资
    private Double sal;//总薪资
    private Integer state;
    private String intro;

    public Sal() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMonthtime() {
        return monthtime;
    }

    public void setMonthtime(Date monthtime) {
        this.monthtime = monthtime;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Double getJsal() {
        return jsal;
    }

    public void setJsal(Double jsal) {
        this.jsal = jsal;
    }

    public Double getPfsal() {
        return pfsal;
    }

    public void setPfsal(Double pfsal) {
        this.pfsal = pfsal;
    }

    public Double getOversal() {
        return oversal;
    }

    public void setOversal(Double oversal) {
        this.oversal = oversal;
    }

    public Double getRapsal() {
        return rapsal;
    }

    public void setRapsal(Double rapsal) {
        this.rapsal = rapsal;
    }

    public Double getSssal() {
        return sssal;
    }

    public void setSssal(Double sssal) {
        this.sssal = sssal;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Sal{" +
                "id=" + id +
                ", monthtime=" + monthtime +
                ", emp=" + emp +
                ", jsal=" + jsal +
                ", pfsal=" + pfsal +
                ", oversal=" + oversal +
                ", rapsal=" + rapsal +
                ", sssal=" + sssal +
                ", sal=" + sal +
                ", state=" + state +
                ", intro='" + intro + '\'' +
                '}';
    }
}
