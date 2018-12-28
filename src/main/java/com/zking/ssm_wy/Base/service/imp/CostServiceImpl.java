package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.CostMapper;
import com.zking.ssm_wy.Base.model.Cost;
import com.zking.ssm_wy.Base.service.ICostService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class CostServiceImpl implements ICostService {
    @Autowired
    private CostMapper costMapper;
    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> queryCostPage(String h_number, PageBean pageBean) {
        return costMapper.queryCostPager(h_number);
    }
    @Transactional
    @Override
    public int updateCost(Cost cost) {
        return costMapper.updateCost(cost);
    }

    @Override
    public int deleteCost(Cost cost) {
        return costMapper.deleteCost(cost);
    }

    @Override
    public int insertCost(Cost cost) {
        return costMapper.insertCost(cost);
    }

    @Override
    public List<Map<String, Object>> queryCostfwPage(List<String> lifj, String qq, String zq, List<String> lify, PageBean pb) {
        return costMapper.queryCostfwPage(lifj,qq,zq,lify);
    }

    @Override
    public List<Map<String, Object>> queryrq(String qq, String zq) {
        return costMapper.queryrq(qq,zq);
    }


}
