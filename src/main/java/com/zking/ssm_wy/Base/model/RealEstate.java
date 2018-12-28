package com.zking.ssm_wy.Base.model;

import java.util.Date;

public class RealEstate {
    private int reid;
    private String renumber;
    private Double reprice;
    private Date redate;
    private String refkfs;
    private String oname;
    private String recard;
    private String rephone;
    private String ophone;
    private String reremarks;
    private String hnumber;
    private String onumber;

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public String getRenumber() {
        return renumber;
    }

    public void setRenumber(String renumber) {
        this.renumber = renumber;
    }

    public Double getReprice() {
        return reprice;
    }

    public void setReprice(Double reprice) {
        this.reprice = reprice;
    }

    public Date getRedate() {
        return redate;
    }

    public void setRedate(Date redate) {
        this.redate = redate;
    }

    public String getRefkfs() {
        return refkfs;
    }

    public void setRefkfs(String refkfs) {
        this.refkfs = refkfs;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getRecard() {
        return recard;
    }

    public void setRecard(String recard) {
        this.recard = recard;
    }

    public String getRephone() {
        return rephone;
    }

    public void setRephone(String rephone) {
        this.rephone = rephone;
    }

    public String getOphone() {
        return ophone;
    }

    public void setOphone(String ophone) {
        this.ophone = ophone;
    }

    public String getReremarks() {
        return reremarks;
    }

    public void setReremarks(String reremarks) {
        this.reremarks = reremarks;
    }

    public String getHnumber() {
        return hnumber;
    }

    public void setHnumber(String hnumber) {
        this.hnumber = hnumber;
    }

    public String getOnumber() {
        return onumber;
    }

    public void setOnumber(String onumber) {
        this.onumber = onumber;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "reid=" + reid +
                ", renumber='" + renumber + '\'' +
                ", reprice=" + reprice +
                ", redate=" + redate +
                ", refkfs='" + refkfs + '\'' +
                ", oname='" + oname + '\'' +
                ", recard='" + recard + '\'' +
                ", rephone='" + rephone + '\'' +
                ", ophone='" + ophone + '\'' +
                ", reremarks='" + reremarks + '\'' +
                ", hnumber='" + hnumber + '\'' +
                ", onumber='" + onumber + '\'' +
                '}';
    }
}
