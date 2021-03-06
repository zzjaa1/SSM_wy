package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.RealEstate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RealEstateMapper {
    String addReal(RealEstate realEstate);

    List<Map<String,Object>> querytj(String year);

    int queryHtbh();

    List<Map<String,Object>> queryRealEstatePage(RealEstate realEstate);
//    List<Map<String,Object>> querytj();

    List<Map<String,Object>> queryxsetj(@Param("year") String year);

    List<Map<String,Object>> queryxsetj2(@Param("year")String year,@Param("x_number")String x_number,@Param("mouth")String mouth);


}
