package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.CostName;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CostNameMapper {
    int deleteByPrimaryKey(Integer cnId);

    int insert(CostName record);

    int insertSelective(CostName record);

    CostName selectByPrimaryKey(Integer cnId);

    int updateByPrimaryKeySelective(CostName record);

    int updateByPrimaryKey(CostName record);

    List<Map<String,Object>> queryCostNamePage(CostName costn);

    List<Map<String,Object>> queryName();



}