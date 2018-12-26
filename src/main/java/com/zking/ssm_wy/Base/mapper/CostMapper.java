package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.Cost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CostMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    List<Map<String,Object>> queryCostPager(String h_number);

    int updateCost(Cost cost);

    int insertCost(Cost cost);

    int deleteCost(Cost cost);

    List<Map<String,Object>> queryCostfwPage(@Param("lifj") List<String> lifj,@Param("qq")String qq,@Param("zq")String zq,@Param("lify")List<String> lify);
}