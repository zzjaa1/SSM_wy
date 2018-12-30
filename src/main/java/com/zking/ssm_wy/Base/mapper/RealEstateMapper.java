package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.RealEstate;

import java.util.List;
import java.util.Map;

public interface RealEstateMapper {
    String addReal(RealEstate realEstate);

    List<Map<String,Object>> querytj();
}
