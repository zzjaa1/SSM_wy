package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Logs;
import com.zking.ssm_wy.Base.service.ILogsService;
import com.zking.ssm_wy.Base.util.PageBean;
import com.zking.ssm_wy.annotation.SystemControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LogsController {

    @Autowired
    private ILogsService iLogsService;

    @RequestMapping("/querylogPage")
    @ResponseBody
    @SystemControllerLog(description = "日志查询")
    public Map<String,Object> querylogPage(Logs logs, int page, int limit, HttpServletRequest request){
        PageBean pageBean= new PageBean();
        pageBean.setRows(limit);
        pageBean.setPage(page);
        pageBean.setRequest(request);
        List<Map<String, Object>> maps = iLogsService.queryLogPage(logs, pageBean);
        Map<String,Object> map =new HashMap<>();
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        return map;
    }
}

