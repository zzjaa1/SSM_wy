package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Cost;
import com.zking.ssm_wy.Base.service.ICostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CostController {

    @Autowired
    private ICostService iCostService;

    @RequestMapping("/queryCost")
    @ResponseBody
    public Map<String, Object> queryCost(String hNumber){
        System.out.println(hNumber);
        List<Map<String, Object>> maps = iCostService.queryCostPager(hNumber);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
        Map<String,Object> map =new HashMap<>();
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",0);

        return map;
    }

}
