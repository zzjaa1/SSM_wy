package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Houses;

import java.util.List;
import java.util.Map;

public interface IHousesService {
    List<Map<String,Object>> queryHourse(String number);

    List<Map<String,Object>> queryBulidingName(String bulidingName);

    List<Map<String,Object>> queryState(String state);

    void UpdateState(String hun);

}