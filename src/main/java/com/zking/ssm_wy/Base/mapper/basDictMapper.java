package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.basDict;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Resource
public interface basDictMapper {
    int deleteByPrimaryKey(Long dictId);

    int insert(basDict record);

    int insertSelective(basDict record);

    basDict selectByPrimaryKey(Long dictId);

    int updateByPrimaryKeySelective(basDict record);

    int updateByPrimaryKey(basDict record);

    List<Map<String,Object>> querybasDict(basDict basdict);
}