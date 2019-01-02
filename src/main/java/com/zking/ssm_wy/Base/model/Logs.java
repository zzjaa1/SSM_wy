package com.zking.ssm_wy.Base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@ToString
public class Logs {
    private String logid;

    private String logparams;

    private String logname;

    private String logip;


    private Timestamp logcreatetime;

    private String moid;

    private Integer userid;

    public Logs(String logid, String logparams, String logname, String logip, Timestamp logcreatetime, String moid, Integer userid) {
        this.logid = logid;
        this.logparams = logparams;
        this.logname = logname;
        this.logip = logip;
        this.logcreatetime = logcreatetime;
        this.moid = moid;
        this.userid = userid;
    }

    public Logs() {
        super();
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getLogparams() {
        return logparams;
    }

    public void setLogparams(String logparams) {
        this.logparams = logparams;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public String getLogip() {
        return logip;
    }

    public void setLogip(String logip) {
        this.logip = logip;
    }

    public Date getLogcreatetime() {
        return logcreatetime;
    }

    public void setLogcreatetime(Timestamp logcreatetime) {
        this.logcreatetime = logcreatetime;
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}