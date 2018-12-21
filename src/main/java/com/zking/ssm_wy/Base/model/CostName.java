package com.zking.ssm_wy.Base.model;

public class CostName {
    private Integer cnId;

    private String cnName;

    private String cnType;

    private Float cnPrice;

    private Integer cnCycle;

    private String cnRemarks;

    public CostName(Integer cnId, String cnName, String cnType, Float cnPrice, Integer cnCycle, String cnRemarks) {
        this.cnId = cnId;
        this.cnName = cnName;
        this.cnType = cnType;
        this.cnPrice = cnPrice;
        this.cnCycle = cnCycle;
        this.cnRemarks = cnRemarks;
    }

    public CostName() {
        super();
    }

    public Integer getCnId() {
        return cnId;
    }

    public void setCnId(Integer cnId) {
        this.cnId = cnId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getCnType() {
        return cnType;
    }

    public void setCnType(String cnType) {
        this.cnType = cnType;
    }

    public Float getCnPrice() {
        return cnPrice;
    }

    public void setCnPrice(Float cnPrice) {
        this.cnPrice = cnPrice;
    }

    public Integer getCnCycle() {
        return cnCycle;
    }

    public void setCnCycle(Integer cnCycle) {
        this.cnCycle = cnCycle;
    }

    public String getCnRemarks() {
        return cnRemarks;
    }

    public void setCnRemarks(String cnRemarks) {
        this.cnRemarks = cnRemarks;
    }
}