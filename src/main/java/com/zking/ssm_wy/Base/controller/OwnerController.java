package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Owner;
import com.zking.ssm_wy.Base.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OwnerController {
    @Autowired
    private IOwnerService iOwnerService;
    @RequestMapping("/queryOwner")
    @ResponseBody
    public Map<String,Object> queryOwner(String oname){
        System.out.println("name="+oname);
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = iOwnerService.queryOwner(oname);
        map.put("date",maps);
        map.put("code",0);
        map.put("count",0);
        map.put("msg","");
        return map;
    }
}
