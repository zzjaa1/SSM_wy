package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Cost;
import com.zking.ssm_wy.Base.service.ICostService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Cost")
public class CostController {

    @Autowired
    private ICostService iCostService;

    @RequestMapping("/queryCost")
    @ResponseBody
    public Map<String, Object> queryCost(String hNumber, HttpServletRequest request,int page,int limit){
        System.out.println(hNumber);
        PageBean pageBean =new PageBean();
        pageBean.setRows(limit);
        pageBean.setPage(page);
        pageBean.setRequest(request);
        List<Map<String, Object>> maps = iCostService.queryCostPage(hNumber,pageBean);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
        Map<String,Object> map =new HashMap<>();
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());

        return map;
    }

    @ResponseBody
    @RequestMapping("/UpdateCost")
    public Map<String,Object> UpdateCost(Cost cost){
        System.out.println("111");
        System.out.println(cost);

            iCostService.updateCost(cost);
        Map<String,Object> map =new HashMap<>();
            map.put("success",true);
            map.put("msg","成功");

        return map;
    }


    @RequestMapping("/DeleteCost")
    @ResponseBody
    public Map<String,Object> DeleteCost(Cost cost){

        iCostService.deleteCost(cost);
        Map<String,Object> map =new HashMap<>();
        map.put("success",true);
        map.put("msg","成功");
        return map;
    }

    @RequestMapping("/insertCost")
    @ResponseBody
    public Map<String,Object> insertCost(Cost cost){
        System.out.println(cost);
        iCostService.insertCost(cost);
        Map<String,Object> map =new HashMap<>();
        map.put("success",true);
        map.put("msg","成功");
        return map;
    }

}
