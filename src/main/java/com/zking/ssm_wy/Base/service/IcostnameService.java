package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.CostName;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public interface IcostnameService {

    List<Map<String,Object>> queryCostNamePage(CostName costn, PageBean pb);

    int updateByPrimaryKeySelective(CostName record);

    int deleteByPrimaryKey(Integer cnId);

    int insertSelective(CostName record);

    List<Map<String,Object>> queryName();
}