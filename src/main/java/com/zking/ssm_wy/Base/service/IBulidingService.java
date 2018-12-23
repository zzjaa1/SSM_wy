package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Buliding;

import java.util.List;
import java.util.Map;

public interface IBulidingService {
    List<Map<String,Object>> queryBulid(String x_number);

    int insertSelective(Buliding record);

    String QueryId();
}