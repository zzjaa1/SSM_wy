package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.SysPermission;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer perid);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer perid);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<Map<String,Object>> queryPermission(String pid);

    //根据用户id查询对应的角色
    List<Map<String,Object>> queryPermissione2(Integer userid);

}