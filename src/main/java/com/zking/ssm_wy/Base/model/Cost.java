package com.zking.ssm_wy.Base.model;

import lombok.ToString;

import java.util.Date;

@ToString
public class Cost {
    private Integer cId;

    private String cFc;

    private String cUser;

    private Float cJfdw;

    private Float cDwjg;

    private Float cYjfy;

    private Date cScfyzqDate;

    private Date cBcfyqqDate;

    private Date cBcfyzqDate;

    private Date cBcjfzqDate;

    private String cCostname;

    private Integer cReal;

    private String cRemarks;

    private String hNumber;

    private Integer cnId;

    public Cost(Integer cId, String cFc, String cUser, Float cJfdw, Float cDwjg, Float cYjfy, Date cScfyzqDate, Date cBcfyqqDate, Date cBcfyzqDate, Date cBcjfzqDate, String cCostname, Integer cReal, String cRemarks, String hNumber, Integer cnId) {
        this.cId = cId;
        this.cFc = cFc;
        this.cUser = cUser;
        this.cJfdw = cJfdw;
        this.cDwjg = cDwjg;
        this.cYjfy = cYjfy;
        this.cScfyzqDate = cScfyzqDate;
        this.cBcfyqqDate = cBcfyqqDate;
        this.cBcfyzqDate = cBcfyzqDate;
        this.cBcjfzqDate = cBcjfzqDate;
        this.cCostname = cCostname;
        this.cReal = cReal;
        this.cRemarks = cRemarks;
        this.hNumber = hNumber;
        this.cnId = cnId;
    }

    public Cost() {
        super();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcFc() {
        return cFc;
    }

    public void setcFc(String cFc) {
        this.cFc = cFc;
    }

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public Float getcJfdw() {
        return cJfdw;
    }

    public void setcJfdw(Float cJfdw) {
        this.cJfdw = cJfdw;
    }

    public Float getcDwjg() {
        return cDwjg;
    }

    public void setcDwjg(Float cDwjg) {
        this.cDwjg = cDwjg;
    }

    public Float getcYjfy() {
        return cYjfy;
    }

    public void setcYjfy(Float cYjfy) {
        this.cYjfy = cYjfy;
    }

    public Date getcScfyzqDate() {
        return cScfyzqDate;
    }

    public void setcScfyzqDate(Date cScfyzqDate) {
        this.cScfyzqDate = cScfyzqDate;
    }

    public Date getcBcfyqqDate() {
        return cBcfyqqDate;
    }

    public void setcBcfyqqDate(Date cBcfyqqDate) {
        this.cBcfyqqDate = cBcfyqqDate;
    }

    public Date getcBcfyzqDate() {
        return cBcfyzqDate;
    }

    public void setcBcfyzqDate(Date cBcfyzqDate) {
        this.cBcfyzqDate = cBcfyzqDate;
    }

    public Date getcBcjfzqDate() {
        return cBcjfzqDate;
    }

    public void setcBcjfzqDate(Date cBcjfzqDate) {
        this.cBcjfzqDate = cBcjfzqDate;
    }

    public String getcCostname() {
        return cCostname;
    }

    public void setcCostname(String cCostname) {
        this.cCostname = cCostname;
    }

    public Integer getcReal() {
        return cReal;
    }

    public void setcReal(Integer cReal) {
        this.cReal = cReal;
    }

    public String getcRemarks() {
        return cRemarks;
    }

    public void setcRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    public String gethNumber() {
        return hNumber;
    }

    public void sethNumber(String hNumber) {
        this.hNumber = hNumber;
    }

    public Integer getCnId() {
        return cnId;
    }

    public void setCnId(Integer cnId) {
        this.cnId = cnId;
    }
}