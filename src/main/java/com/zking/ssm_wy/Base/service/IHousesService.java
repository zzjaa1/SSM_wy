package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Houses;

import java.util.List;
import java.util.Map;

public interface IHousesService {
    List<Map<String,Object>> queryHourse(String number);

}