package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}