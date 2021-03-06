package com.zking.ssm_wy.Base.model;

import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

@ToString
public class SysUser {
    private Integer userid;

    private String username;

    private String password;

    private String salt;

    private Date createdate;

    //用户对应的模块信息
    private List<Map<String, Object>> sysPermissions;

    public List<Map<String, Object>> getSysPermissions() {
        return sysPermissions;
    }

    public void setSysPermissions(List<Map<String, Object>> sysPermissions) {
        this.sysPermissions = sysPermissions;
    }

    public SysUser(Integer userid, String username, String password, String salt, Date createdate) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.createdate = createdate;
    }

    public SysUser() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}