package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.SysUser;
import com.zking.ssm_wy.Base.service.ISysPermissionService;
import com.zking.ssm_wy.annotation.SystemControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @SystemControllerLog(description = "查询模块")
    public Map<String,Object> query(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        SysUser sysUser= (SysUser) request.getSession().getAttribute("User");
        List<Map<String,Object>> li=new ArrayList<>();
        List<Map<String,Object>> li2=null;
        for (Map<String,Object> stringObjectMap : sysUser.getSysPermissions()) {
            if(stringObjectMap.get("pid").toString().equals("-1")){
                li2=new ArrayList<>();
                for (Map<String,Object> objectMap : sysUser.getSysPermissions()) {
                    if(stringObjectMap.get("perid").toString().equals(objectMap.get("pid").toString())){
                        li2.add(objectMap);
                    }
                }
                stringObjectMap.put("childs",li2);
                li.add(stringObjectMap);
            }
        }
        for (Map<String, Object> stringObjectMap : li) {
            System.out.println("li="+stringObjectMap.toString());
        }
        //List<Map<String, Object>> maps=querys("-1");
        map.put("li",li);
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
