package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.RealEstate;

import java.util.List;
import java.util.Map;

public interface IRealEstateService {

    String addReal(RealEstate realEstate);

    List<Map<String,Object>> querytj();

    List<Map<String,Object>> queryxsetj(String year);

    List<Map<String,Object>> queryxsetj2(String year,String x_number,String mouth);
    List<Map<String,Object>> querytj(String year);

    int queryHtbh();

    List<Map<String,Object>> queryRealEstatePage(RealEstate realEstate);
}
