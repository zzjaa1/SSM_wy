package com.zking.ssm_wy.Base.model;

import java.util.Date;

public class Lease {
    private int lid ;
    private String lnumber;
    private String lzh;
    private Date ldate;
    private String lhtzt;
    private String lfrdb;
    private String llxr;
    private Date lqzrq;
    private Date ltzrq;
    private Float lbzj;
    private Float lsfmj;
    private String lsfsq;
    private Float lzjze;
    private String lremarks;
    private String hnumber;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLnumber() {
        return lnumber;
    }

    public void setLnumber(String lnumber) {
        this.lnumber = lnumber;
    }

    public String getLzh() {
        return lzh;
    }

    public void setLzh(String lzh) {
        this.lzh = lzh;
    }

    public Date getLdate() {
        return ldate;
    }

    public void setLdate(Date ldate) {
        this.ldate = ldate;
    }

    public String getLhtzt() {
        return lhtzt;
    }

    public void setLhtzt(String lhtzt) {
        this.lhtzt = lhtzt;
    }

    public String getLfrdb() {
        return lfrdb;
    }

    public void setLfrdb(String lfrdb) {
        this.lfrdb = lfrdb;
    }

    public String getLlxr() {
        return llxr;
    }

    public void setLlxr(String llxr) {
        this.llxr = llxr;
    }

    public Date getLqzrq() {
        return lqzrq;
    }

    public void setLqzrq(Date lqzrq) {
        this.lqzrq = lqzrq;
    }

    public Date getLtzrq() {
        return ltzrq;
    }

    public void setLtzrq(Date ltzrq) {
        this.ltzrq = ltzrq;
    }

    public Float getLbzj() {
        return lbzj;
    }

    public void setLbzj(Float lbzj) {
        this.lbzj = lbzj;
    }

    public Float getLsfmj() {
        return lsfmj;
    }

    public void setLsfmj(Float lsfmj) {
        this.lsfmj = lsfmj;
    }

    public String getLsfsq() {
        return lsfsq;
    }

    public void setLsfsq(String lsfsq) {
        this.lsfsq = lsfsq;
    }

    public Float getLzjze() {
        return lzjze;
    }

    public void setLzjze(Float lzjze) {
        this.lzjze = lzjze;
    }

    public String getLremarks() {
        return lremarks;
    }

    public void setLremarks(String lremarks) {
        this.lremarks = lremarks;
    }

    public String getHnumber() {
        return hnumber;
    }

    public void setHnumber(String hnumber) {
        this.hnumber = hnumber;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "lid=" + lid +
                ", lnumber='" + lnumber + '\'' +
                ", lzh='" + lzh + '\'' +
                ", ldate=" + ldate +
                ", lhtzt='" + lhtzt + '\'' +
                ", lfrdb='" + lfrdb + '\'' +
                ", llxr='" + llxr + '\'' +
                ", lqzrq=" + lqzrq +
                ", ltzrq=" + ltzrq +
                ", lbzj=" + lbzj +
                ", lsfmj=" + lsfmj +
                ", lsfsq='" + lsfsq + '\'' +
                ", lzjze=" + lzjze +
                ", lremarks='" + lremarks + '\'' +
                ", hnumber='" + hnumber + '\'' +
                '}';
    }
}
