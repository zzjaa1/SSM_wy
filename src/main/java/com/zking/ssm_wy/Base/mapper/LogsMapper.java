package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.Logs;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LogsMapper {
    int insert(Logs record);

    int insertSelective(Logs record);

    List<Map<String,Object>> queryLogPage(Logs logs);

}