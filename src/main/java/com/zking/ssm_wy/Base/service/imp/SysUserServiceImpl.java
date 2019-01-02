package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.SysUserMapper;
import com.zking.ssm_wy.Base.model.SysUser;
import com.zking.ssm_wy.Base.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Transactional
    @Override
    public SysUser userLogin(SysUser sysUser) {
        return sysUserMapper.userLogin(sysUser);
    }
}
