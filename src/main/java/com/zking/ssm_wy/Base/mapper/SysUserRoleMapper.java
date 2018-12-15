package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}