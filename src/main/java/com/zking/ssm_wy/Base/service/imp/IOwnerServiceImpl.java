package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.OwnerMapper;
import com.zking.ssm_wy.Base.model.Owner;
import com.zking.ssm_wy.Base.service.IOwnerService;
import com.zking.ssm_wy.Base.util.PageBean;
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

    @Override
    public List<Map<String, Object>> queryowenPage(String o_name ,String h_number,PageBean pageBean) {
        return ownerMapper.queryowenPage(o_name,h_number);
    }

    @Override
    public int UpdateOwen(Owner owner) {
        return ownerMapper.UpdateOwen(owner);
    }

    @Override
    public int deleteOwen(String O_number) {
        return ownerMapper.deleteOwen(O_number);
    }

}
