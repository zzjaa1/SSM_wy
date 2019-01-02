package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Cost;
import com.zking.ssm_wy.Base.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ICostService {
    List<Map<String,Object>> queryCostPage(String h_number, PageBean pageBean);

    int updateCost(Cost cost);

    int deleteCost(Cost cost);

    int insertCost(Cost cost);

    List<Map<String,Object>> queryCostfwPage(List<String> lifj,String qq,String zq,List<String> lify,PageBean pb);

    List<Map<String,Object>> queryrq(String qq, String zq);

    int Updacostate(Integer cid);

    int insert(Cost record);

    int MaxCostNumber();

    void InsetsCost(List<Map<String, Object>> list);

    void updateth(List<Map<String,Object>> list);

    List<Map<String,Object>> queryJfCost(List<Map<String,Object>> list);

    void UpdateJsDD(List<Map<String,Object>> list);

}