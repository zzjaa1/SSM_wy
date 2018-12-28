package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.RealEstateMapper;
import com.zking.ssm_wy.Base.model.RealEstate;
import com.zking.ssm_wy.Base.service.IRealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class IRealEstateServiceImpl implements IRealEstateService{
    @Autowired
    private RealEstateMapper realEstateMapper;

    @Override
    public String addReal(RealEstate realEstate) {
        return realEstateMapper.addReal(realEstate);
    }

    @Override
    public List<Map<String, Object>> querytj(String year) {
        return realEstateMapper.querytj(year);
    }
}
