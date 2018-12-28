package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.XiaoQu;
import com.zking.ssm_wy.Base.vo.XiaoQuVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository

public interface XiaoQuMapper {
    int deleteByPrimaryKey(Integer xId);

    int insert(XiaoQu record);

    int insertSelective(XiaoQu record);

    XiaoQu selectByPrimaryKey(Integer xId);

    int updateByPrimaryKeySelective(XiaoQu record);

    int updateByPrimaryKey(XiaoQu record);

    List<Map<String,Object>> querysf(XiaoQuVo xiaoQuVo);

    List<Map<String,Object>> queryxq(XiaoQu xiaoQu);

    String queryXId();


}