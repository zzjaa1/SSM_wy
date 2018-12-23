package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Cost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class sfController {

    @RequestMapping("/queryCost")
    @ResponseBody
    public Map<String, Object> queryCost(@RequestBody List<Object> lis){
        System.out.println("lis="+lis.toString());
        Map<String,Object> map =new HashMap<>();
        map.put("data","2");
        return  map;
    }

}
