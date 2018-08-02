package com.iotek.model;

/**
 * Created by TCY on 2018/8/2.
 */
public class EC {
    private Integer id;
    private Emp emp;
    private Cul cul;

    public EC() {
    }

    public EC(Emp emp, Cul cul) {
        this.emp = emp;
        this.cul = cul;
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

    public Cul getCul() {
        return cul;
    }

    public void setCul(Cul cul) {
        this.cul = cul;
    }

    @Override
    public String toString() {
        return "EC{" +
                "id=" + id +
                ", emp=" + emp +
                ", cul=" + cul +
                '}';
    }
}
