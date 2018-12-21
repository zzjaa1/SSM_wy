package com.zking.ssm_wy.Base.model;

import lombok.ToString;

@ToString
public class XiaoQu {
    private Integer xId;

    private String xNumber;

    private String xBuliding;

    private Integer xMj;

    private Integer xXuliding;

    private Integer xUnitnumber;

    private Integer xNuberj;

    private Integer xHoursnumber;

    private String xRemarks;

    public XiaoQu(Integer xId, String xNumber, String xBuliding, Integer xMj, Integer xXuliding, Integer xUnitnumber, Integer xNuberj, Integer xHoursnumber, String xRemarks) {
        this.xId = xId;
        this.xNumber = xNumber;
        this.xBuliding = xBuliding;
        this.xMj = xMj;
        this.xXuliding = xXuliding;
        this.xUnitnumber = xUnitnumber;
        this.xNuberj = xNuberj;
        this.xHoursnumber = xHoursnumber;
        this.xRemarks = xRemarks;
    }

    public XiaoQu() {
        super();
    }

    public Integer getxId() {
        return xId;
    }

    public void setxId(Integer xId) {
        this.xId = xId;
    }

    public String getxNumber() {
        return xNumber;
    }

    public void setxNumber(String xNumber) {
        this.xNumber = xNumber;
    }

    public String getxBuliding() {
        return xBuliding;
    }

    public void setxBuliding(String xBuliding) {
        this.xBuliding = xBuliding;
    }

    public Integer getxMj() {
        return xMj;
    }

    public void setxMj(Integer xMj) {
        this.xMj = xMj;
    }

    public Integer getxXuliding() {
        return xXuliding;
    }

    public void setxXuliding(Integer xXuliding) {
        this.xXuliding = xXuliding;
    }

    public Integer getxUnitnumber() {
        return xUnitnumber;
    }

    public void setxUnitnumber(Integer xUnitnumber) {
        this.xUnitnumber = xUnitnumber;
    }

    public Integer getxNuberj() {
        return xNuberj;
    }

    public void setxNuberj(Integer xNuberj) {
        this.xNuberj = xNuberj;
    }

    public Integer getxHoursnumber() {
        return xHoursnumber;
    }

    public void setxHoursnumber(Integer xHoursnumber) {
        this.xHoursnumber = xHoursnumber;
    }

    public String getxRemarks() {
        return xRemarks;
    }

    public void setxRemarks(String xRemarks) {
        this.xRemarks = xRemarks;
    }
}