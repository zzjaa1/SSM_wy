package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys")
public class SysController {

    @Autowired
    ISysPermissionService iSysPermissionService;

    @RequestMapping("/queryPermission")
    @ResponseBody
    public Map<String,Object> query(){
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps=querys("-1");
        map.put("li",maps);
        return map;
    }

    public List<Map<String,Object>> querys(String pid){
        List<Map<String, Object>> maps = iSysPermissionService.queryPermission(pid);
        for (Map<String, Object> map : maps) {
                if(map.get("perid").toString().length()<4)
                    map.put("childs",querys(map.get("perid").toString()));
        }
        return maps;
    }

}
