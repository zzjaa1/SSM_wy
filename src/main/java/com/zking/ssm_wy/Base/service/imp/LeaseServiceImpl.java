package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.LeaseMapper;
import com.zking.ssm_wy.Base.model.Lease;
import com.zking.ssm_wy.Base.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LeaseServiceImpl implements LeaseService{
    @Autowired
    private LeaseMapper leaseMapper;

    @Override
    public String addLease(Lease lease) {
        return leaseMapper.addLease(lease);
    }
}
