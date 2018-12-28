package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.basDict;
import com.zking.ssm_wy.Base.util.PageBean;

import java.util.List;
import java.util.Map;

public interface IbasDictService {

    List<Map<String,Object>> querybasDict(basDict basdict);

    List<Map<String,Object>> querybasDictPage(basDict basdict,PageBean pb);

    int deleteByPrimaryKey(Long dictId);

    int insertSelective(basDict record);

    int updateByPrimaryKeySelective(basDict record);

    void updpl(List<Map<String,Object>> list);

    void delpl(List<Map<String,Object>> list);
}