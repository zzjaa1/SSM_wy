package com.zking.ssm_wy.Base.model;

import java.util.Date;

public class Repairs {
    private int rpid;
    private String rpodd;
    private String hnumber;
    private String rpname;
    private String rpphone;
    private Date rpdate;
    private String rpstate;

    public int getRpid() {
        return rpid;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    public String getRpodd() {
        return rpodd;
    }

    public void setRpodd(String rpodd) {
        this.rpodd = rpodd;
    }

    public String getHnumber() {
        return hnumber;
    }

    public void setHnumber(String hnumber) {
        this.hnumber = hnumber;
    }

    public String getRpname() {
        return rpname;
    }

    public void setRpname(String rpname) {
        this.rpname = rpname;
    }

    public String getRpphone() {
        return rpphone;
    }

    public void setRpphone(String rpphone) {
        this.rpphone = rpphone;
    }

    public Date getRpdate() {
        return rpdate;
    }

    public void setRpdate(Date rpdate) {
        this.rpdate = rpdate;
    }

    public String getRpstate() {
        return rpstate;
    }

    public void setRpstate(String rpstate) {
        this.rpstate = rpstate;
    }

    @Override
    public String toString() {
        return "Repairs{" +
                "rpid=" + rpid +
                ", rpodd='" + rpodd + '\'' +
                ", hnumber='" + hnumber + '\'' +
                ", rpname='" + rpname + '\'' +
                ", rpphone='" + rpphone + '\'' +
                ", rpdate=" + rpdate +
                ", rpstate='" + rpstate + '\'' +
                '}';
    }
}
