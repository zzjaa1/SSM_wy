package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.SysPermission;

import java.util.List;
import java.util.Map;

public interface ISysPermissionService {
    List<Map<String,Object>> queryPermission(String pid);

    List<Map<String,Object>> queryPermissione2(Integer userid);
}