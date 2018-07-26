package com.iotek.model;

/**
 * Created by TCY on 2018/7/26.
 */
//接受简历的表
public class GetCV {
    private Integer id;
    private CV cv;
    private Recr recr;
    private Integer state;//0表示未读，1表示发送面试邀请，2表示不合适

    public GetCV() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public Recr getRecr() {
        return recr;
    }

    public void setRecr(Recr recr) {
        this.recr = recr;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "GetCV{" +
                "id=" + id +
                ", cv=" + cv +
                ", recr=" + recr +
                ", state=" + state +
                '}';
    }
}
