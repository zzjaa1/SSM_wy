package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.OwnerMapper;
import com.zking.ssm_wy.Base.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class IOwnerServiceImpl implements IOwnerService{

    @Autowired
    private OwnerMapper ownerMapper;
    @Override
    public List<Map<String, Object>> queryOwner(String name) {
        return ownerMapper.queryOwner(name);
    }
}
