package com.iotek.model;

import java.util.Date;

/**
 * Created by TCY on 2018/8/3.
 */
public class Sal {
    private Integer id;
    private Date monthtime;
    private Integer eid;
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

    public Sal(Date monthtime, Integer eid, Double jsal, Double pfsal, Double oversal, Double rapsal, Double sssal, Double sal, Integer state, String intro) {
        this.monthtime = monthtime;
        this.eid = eid;
        this.jsal = jsal;
        this.pfsal = pfsal;
        this.oversal = oversal;
        this.rapsal = rapsal;
        this.sssal = sssal;
        this.sal = sal;
        this.state = state;
        this.intro = intro;
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

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
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
                ", eid=" + eid +
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
