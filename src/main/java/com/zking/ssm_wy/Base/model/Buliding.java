package com.zking.ssm_wy.Base.model;

import lombok.ToString;

@ToString
public class Buliding {
    private Integer bId;

    private String bBuliding;

    private String bHours;

    private Integer bUnitnumber;

    private Integer bNuberj;

    private Integer bHoursnumber;

    private String csRemarks;

    private String xNumber;

    private String bNumber;

    private int X;
    private int Y;


    public Buliding(Integer bId, String bBuliding, String bHours, Integer bUnitnumber, Integer bNuberj, Integer bHoursnumber, String csRemarks, String xNumber, String bNumber, int x, int y) {
        this.bId = bId;
        this.bBuliding = bBuliding;
        this.bHours = bHours;
        this.bUnitnumber = bUnitnumber;
        this.bNuberj = bNuberj;
        this.bHoursnumber = bHoursnumber;
        this.csRemarks = csRemarks;
        this.xNumber = xNumber;
        this.bNumber = bNumber;
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public Buliding() {
        super();
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbBuliding() {
        return bBuliding;
    }

    public void setbBuliding(String bBuliding) {
        this.bBuliding = bBuliding;
    }

    public String getbHours() {
        return bHours;
    }

    public void setbHours(String bHours) {
        this.bHours = bHours;
    }

    public Integer getbUnitnumber() {
        return bUnitnumber;
    }

    public void setbUnitnumber(Integer bUnitnumber) {
        this.bUnitnumber = bUnitnumber;
    }

    public Integer getbNuberj() {
        return bNuberj;
    }

    public void setbNuberj(Integer bNuberj) {
        this.bNuberj = bNuberj;
    }

    public Integer getbHoursnumber() {
        return bHoursnumber;
    }

    public void setbHoursnumber(Integer bHoursnumber) {
        this.bHoursnumber = bHoursnumber;
    }

    public String getCsRemarks() {
        return csRemarks;
    }

    public void setCsRemarks(String csRemarks) {
        this.csRemarks = csRemarks;
    }

    public String getxNumber() {
        return xNumber;
    }

    public void setxNumber(String xNumber) {
        this.xNumber = xNumber;
    }

    public String getbNumber() {
        return bNumber;
    }

    public void setbNumber(String bNumber) {
        this.bNumber = bNumber;
    }
}