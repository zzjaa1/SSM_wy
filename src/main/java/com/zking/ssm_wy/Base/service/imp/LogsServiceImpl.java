package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.LogsMapper;
import com.zking.ssm_wy.Base.model.Logs;
import com.zking.ssm_wy.Base.service.ILogsService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LogsServiceImpl implements ILogsService {

    @Autowired
    private LogsMapper logsMapper;

    @Override
    public int insertSelective(Logs record) {
        return logsMapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> queryLogPage(Logs logs, PageBean pageBean) {
        return logsMapper.queryLogPage(logs);
    }
}
