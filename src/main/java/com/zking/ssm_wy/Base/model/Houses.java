package com.zking.ssm_wy.Base.model;

public class Houses {
    private Integer hId;

    private String hNumber;

    private String hState;

    private String hBulidingname;

    private Integer hUnitnumber;

    private Integer hFloor;

    private String hType;
    private String hDirection;

    private Integer hArea;

    private String hRemarks;

    private String bNumber;

    public Houses(Integer hId, String hNumber, String hState, String hBulidingname, Integer hUnitnumber, Integer hFloor, String hType, String hDirection, Integer hArea, String hRemarks, String bNumber) {
        this.hId = hId;
        this.hNumber = hNumber;
        this.hState = hState;
        this.hBulidingname = hBulidingname;
        this.hUnitnumber = hUnitnumber;
        this.hFloor = hFloor;
        this.hType = hType;
        this.hDirection = hDirection;
        this.hArea = hArea;
        this.hRemarks = hRemarks;
        this.bNumber = bNumber;
    }

    public Houses() {
        super();
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String gethNumber() {
        return hNumber;
    }

    public void sethNumber(String hNumber) {
        this.hNumber = hNumber;
    }

    public String gethState() {
        return hState;
    }

    public void sethState(String hState) {
        this.hState = hState;
    }

    public String gethBulidingname() {
        return hBulidingname;
    }

    public void sethBulidingname(String hBulidingname) {
        this.hBulidingname = hBulidingname;
    }

    public Integer gethUnitnumber() {
        return hUnitnumber;
    }

    public void sethUnitnumber(Integer hUnitnumber) {
        this.hUnitnumber = hUnitnumber;
    }

    public Integer gethFloor() {
        return hFloor;
    }

    public void sethFloor(Integer hFloor) {
        this.hFloor = hFloor;
    }

    public String gethType() {
        return hType;
    }

    public void sethType(String hType) {
        this.hType = hType;
    }

    public String gethDirection() {
        return hDirection;
    }

    public void sethDirection(String hDirection) {
        this.hDirection = hDirection;
    }

    public Integer gethArea() {
        return hArea;
    }

    public void sethArea(Integer hArea) {
        this.hArea = hArea;
    }

    public String gethRemarks() {
        return hRemarks;
    }

    public void sethRemarks(String hRemarks) {
        this.hRemarks = hRemarks;
    }

    public String getbNumber() {
        return bNumber;
    }

    public void setbNumber(String bNumber) {
        this.bNumber = bNumber;
    }
}