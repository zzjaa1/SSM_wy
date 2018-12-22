package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Cost;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface ICostService {
    List<Map<String,Object>> queryCostPager(String h_number);

    int updateCost(Cost cost);

    int deleteCost(Cost cost);

    int insertCost(Cost cost);
}