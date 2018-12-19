package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.XiaoQu;

import java.util.List;
import java.util.Map;

public interface IXiaoQuService {
    List<Map<String,Object>> querysf();

    List<Map<String,Object>> queryxq();

}