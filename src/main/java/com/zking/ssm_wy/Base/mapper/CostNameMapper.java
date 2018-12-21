package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.CostName;

public interface CostNameMapper {
    int deleteByPrimaryKey(Integer cnId);

    int insert(CostName record);

    int insertSelective(CostName record);

    CostName selectByPrimaryKey(Integer cnId);

    int updateByPrimaryKeySelective(CostName record);

    int updateByPrimaryKey(CostName record);
}