package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.HousesMapper;
import com.zking.ssm_wy.Base.model.Houses;
import com.zking.ssm_wy.Base.service.IHousesService;
import com.zking.ssm_wy.Base.util.PageBean;
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
    public List<Map<String, Object>> queryBulidingNamePage(String bulidingName,PageBean pd) {
        return housesMapper.queryBulidingNamePage(bulidingName);
    }

    @Override
    public List<Map<String, Object>> queryStatePage(String bulidingName,PageBean pd) {
        return housesMapper.queryStatePage(bulidingName);
    }

    @Transactional
    @Override
    public int insertSelective(Houses record) {
        return housesMapper.insertSelective(record);
    }

    @Transactional(readOnly = true)
    @Override
    public String queryHourId() {
        return housesMapper.queryHourId();
    }

    @Override
    public int Updatequery(String bnumber) {
        return housesMapper.Updatequery(bnumber);
    }

    @Transactional
    @Override
    public int DeleteHours(String hnamber) {
        return housesMapper.DeleteHours(hnamber);
    }
    @Transactional
    @Override
    public int updateByPrimaryKeySelective(Houses record) {
        return housesMapper.updateByPrimaryKeySelective(record);
    }
    @Transactional
    @Override
    public void UpdateState(String hun) {
        housesMapper.UpdateState(hun);
    }

    @Override
    public List<Map<String, Object>> queryPricePage(Float price, String hState,PageBean pd) {
        return housesMapper.queryPricePage(price,hState);
    }

    @Override
    public List<Map<String, Object>> queryPriceScopePage(Float price, Float price2,PageBean pd) {
        return housesMapper.queryPriceScopePage(price,price2);
    }


}
