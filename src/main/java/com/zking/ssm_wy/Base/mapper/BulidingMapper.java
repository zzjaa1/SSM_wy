package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.Buliding;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BulidingMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Buliding record);

    int insertSelective(Buliding record);

    Buliding selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Buliding record);

    int updateByPrimaryKeyWithBLOBs(Buliding record);

    int updateByPrimaryKey(Buliding record);

    List<Map<String,Object>> queryBulid(String x_number);
}