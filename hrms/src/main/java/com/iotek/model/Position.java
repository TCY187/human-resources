package com.iotek.model;

/**
 * Created by TCY on 2018/7/27.
 */
public class Position {
    private Integer id;
    private String pname;
    private Depa depa;//部门id
    private Double jsal;
    private Double pf;//绩效因子

    public Position() {
    }

    public Position(Integer id, String pname, Depa depa, Double jsal, Double pf) {
        this.id = id;
        this.pname = pname;
        this.depa = depa;
        this.jsal = jsal;
        this.pf = pf;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", depa=" + depa +
                ", jsal=" + jsal +
                ", pf=" + pf +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Depa getDepa() {
        return depa;
    }

    public void setDepa(Depa depa) {
        this.depa = depa;
    }

    public Double getJsal() {
        return jsal;
    }

    public void setJsal(Double jsal) {
        this.jsal = jsal;
    }

    public Double getPf() {
        return pf;
    }

    public void setPf(Double pf) {
        this.pf = pf;
    }

}
