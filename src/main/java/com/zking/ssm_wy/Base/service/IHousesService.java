package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Houses;
import com.zking.ssm_wy.Base.util.PageBean;

import java.util.List;
import java.util.Map;

public interface IHousesService {
    List<Map<String,Object>> queryHourse(String number);

    List<Map<String,Object>> queryBulidingNamePage(String bulidingName,PageBean pd);

    List<Map<String,Object>> queryStatePage(String state,PageBean pd);

    int insertSelective(Houses record);

    String queryHourId();

    int Updatequery(String bnumber);

    int DeleteHours(String hnamber);

    int updateByPrimaryKeySelective(Houses record);

    void UpdateState(String hun);

    List<Map<String,Object>> queryPricePage(Float price,String hState,PageBean pd);

    List<Map<String,Object>> queryPriceScopePage(Float price,Float price2,PageBean pd);

}