package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.RealEstate;

import java.util.List;
import java.util.Map;

public interface IRealEstateService {

    String addReal(RealEstate realEstate);

    List<Map<String,Object>> querytj(String year);
}
