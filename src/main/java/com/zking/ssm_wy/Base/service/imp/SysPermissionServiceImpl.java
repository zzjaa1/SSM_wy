package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.SysPermissionMapper;
import com.zking.ssm_wy.Base.model.SysPermission;
import com.zking.ssm_wy.Base.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysPermissionServiceImpl implements ISysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Override
    public List<Map<String, Object>> queryPermission(String pid) {
        return sysPermissionMapper.queryPermission(pid);
    }


}
