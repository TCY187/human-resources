package com.iotek.model;

/**
 * Created by TCY on 2018/7/29.
 */
public class Interview {
    private Integer id;
    private User user;
    private Recr recr;
    private Integer state;//0��ʾ�������룬1��ʾ�������룬2��ʾ�ܾ�����,3��ʾ¼�ã�4��ʾ��¼��
    private String address;
    private String remarks;

    public Interview() {
    }

    public Interview(User user, Recr recr, Integer state, String address, String remarks) {
        this.user = user;
        this.recr = recr;
        this.state = state;
        this.address = address;
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", user=" + user +
                ", recr=" + recr +
                ", state=" + state +
                ", address='" + address + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
