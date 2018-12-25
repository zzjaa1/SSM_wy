package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.Houses;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

    public interface HousesMapper {
    int deleteByPrimaryKey(Integer hId);

    int insert(Houses record);

    int insertSelective(Houses record);

    Houses selectByPrimaryKey(Integer hId);

    int updateByPrimaryKeySelective(Houses record);

    int updateByPrimaryKey(Houses record);

    List<Map<String,Object>> queryHourse(String number);
    List<Map<String,Object>> queryBulidingName(String bulidingName);
    List<Map<String,Object>> queryState(String bulidingName);

    String queryHourId();

    int Updatequery(String bnumber);

}