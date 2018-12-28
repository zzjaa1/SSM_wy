package com.zking.ssm_wy.Base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Owner {
    private int oid;
    private String onumber;
    private String oname;
    private String ostate;
    private String ophone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Ojdata;
    private String ocarder;
    private String ownership;
    private Double obefore;
    private String oremarks;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOnumber() {
        return onumber;
    }

    public void setOnumber(String onumber) {
        this.onumber = onumber;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getOstate() {
        return ostate;
    }

    public void setOstate(String ostate) {
        this.ostate = ostate;
    }

    public String getOphone() {
        return ophone;
    }

    public void setOphone(String ophone) {
        this.ophone = ophone;
    }

    public Date getOjdata() {
        return Ojdata;
    }

    public void setOjdata(Date ojdata) {
        Ojdata = ojdata;
    }

    public String getOcarder() {
        return ocarder;
    }

    public void setOcarder(String ocarder) {
        this.ocarder = ocarder;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public Double getObefore() {
        return obefore;
    }

    public void setObefore(Double obefore) {
        this.obefore = obefore;
    }

    public String getOremarks() {
        return oremarks;
    }

    public void setOremarks(String oremarks) {
        this.oremarks = oremarks;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "oid=" + oid +
                ", onumber='" + onumber + '\'' +
                ", oname='" + oname + '\'' +
                ", ostate='" + ostate + '\'' +
                ", ophone=" + ophone +
                ", Ojdata=" + Ojdata +
                ", ocarder='" + ocarder + '\'' +
                ", ownership='" + ownership + '\'' +
                ", obefore=" + obefore +
                ", oremarks='" + oremarks + '\'' +
                '}';
    }
}
