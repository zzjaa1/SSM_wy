package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.HousesMapper;
import com.zking.ssm_wy.Base.service.IHousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Transactional
@Service
public class IHousesServiceImpl implements IHousesService {

    @Autowired
    private HousesMapper housesMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> queryHourse(String number) {
        return housesMapper.queryHourse(number);
    }

    @Override
    public List<Map<String, Object>> queryBulidingName(String bulidingName) {
        return housesMapper.queryBulidingName(bulidingName);
    }

    @Override
    public List<Map<String, Object>> queryState(String bulidingName) {
        return housesMapper.queryState(bulidingName);
    }

    @Override
    public void UpdateState(String hun) {
        housesMapper.UpdateState(hun);
    }


}
