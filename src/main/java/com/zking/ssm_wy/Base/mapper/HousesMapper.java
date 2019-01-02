package com.zking.ssm_wy.Base.mapper;
import com.zking.ssm_wy.Base.model.Houses;
import org.apache.ibatis.annotations.Param;
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

    List<Map<String,Object>> queryHourse(String number);

    List<Map<String,Object>> queryHourses(String number);
    List<Map<String,Object>> queryBulidingNamePage(String bulidingName);
    List<Map<String,Object>> queryStatePage(String bulidingName);

    String queryHourId();

    int Updatequery(String bnumber);

    int DeleteHours(String hnamber);

    void UpdateState(@Param("hun")String hun,@Param("rz")String rz);

    List<Map<String,Object>> queryPricePage(@Param("price")Float price,@Param("hState") String hState);

    List<Map<String,Object>> queryPriceScopePage(@Param("price")Float price,@Param("price2")Float price2);

    List<Map<String,Object>> queryCfcCost();

}