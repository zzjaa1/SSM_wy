package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Buliding;
import com.zking.ssm_wy.annotation.SystemServiceLog;

import java.util.List;
import java.util.Map;

public interface IBulidingService {
    List<Map<String,Object>> queryBulid(String x_number);
    int insertSelective(Buliding record);

    String QueryId();

    int updateunitname(Buliding buliding);

    int update(Buliding buliding);

    int updateByPrimaryKeySelective(Buliding record);

    List<Map<String,Object>> queryB(Buliding b);

    List<Map<String,Object>> queryBB();
}