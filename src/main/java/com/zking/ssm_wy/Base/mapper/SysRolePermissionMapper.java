package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.SysRolePermission;

public interface SysRolePermissionMapper {
    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);
}