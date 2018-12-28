package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Cost;
import com.zking.ssm_wy.Base.util.PageBean;

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
}