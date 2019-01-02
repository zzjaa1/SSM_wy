package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Logs;
import com.zking.ssm_wy.Base.util.PageBean;
import com.zking.ssm_wy.annotation.SystemServiceLog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface ILogsService {
    int insertSelective(Logs record);

    List<Map<String,Object>> queryLogPage(Logs logs, PageBean pageBean);

}