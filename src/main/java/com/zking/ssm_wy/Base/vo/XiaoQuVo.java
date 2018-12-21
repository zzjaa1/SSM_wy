package com.zking.ssm_wy.Base.vo;

import com.zking.ssm_wy.Base.model.XiaoQu;

public class XiaoQuVo extends XiaoQu {
    private  String  number;
    private String gjname;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGjname() {
        return gjname;
    }

    public void setGjname(String gjname) {
        this.gjname = gjname;
    }
}
