package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.XiaoQu;
import com.zking.ssm_wy.Base.vo.XiaoQuVo;

import java.util.List;
import java.util.Map;

public interface IXiaoQuService {
    List<Map<String,Object>> querysf(XiaoQuVo xiaoQuVo);

    List<Map<String,Object>> queryxq(XiaoQu xiaoQu);

}