package com.zking.ssm_wy.Base.model;

public class Complaint {
    private int cid;
    private String codd;
    private  String h_number;
    private String cname;
    private String cphone;
    private String cdate;
    private String cstate;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCodd() {
        return codd;
    }

    public void setCodd(String codd) {
        this.codd = codd;
    }

    public String getH_number() {
        return h_number;
    }

    public void setH_number(String h_number) {
        this.h_number = h_number;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "cid=" + cid +
                ", codd='" + codd + '\'' +
                ", h_number='" + h_number + '\'' +
                ", cname='" + cname + '\'' +
                ", cphone='" + cphone + '\'' +
                ", cdate='" + cdate + '\'' +
                ", cstate='" + cstate + '\'' +
                '}';
    }
}
