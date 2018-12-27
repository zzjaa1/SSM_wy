package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Houses;
import com.zking.ssm_wy.Base.service.IHousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HousesController {

    @Autowired
    private IHousesService iHousesService;

    @RequestMapping("/queryBulidingName")
    @ResponseBody
    public Map<String,Object> queryBulidingName(Houses houses){
        System.out.println(houses.gethBulidingname());
        houses.sethBulidingname("%"+houses.gethBulidingname()+"%");
        System.out.println("bulidingName="+houses.gethBulidingname());
        Map<String,Object> map =new HashMap<>();
        List<Map<String, Object>> maps = iHousesService.queryBulidingName(houses.gethBulidingname());

        map.put("data",maps);
        map.put("code",0);
        map.put("count",0);
        map.put("msg","");
        return map;
    }

    @RequestMapping("/queryState")
    @ResponseBody
    public Map<String,Object> queryState(Houses houses){

        houses.sethBulidingname("%"+houses.gethBulidingname()+"%");
        String bulidingname=houses.gethBulidingname();
        System.out.println("queryState"+houses.gethState());
        System.out.println("queryState"+houses.gethBulidingname());
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = iHousesService.queryState(bulidingname);

        map.put("data",maps);
        map.put("code",0);
        map.put("count",0);
        map.put("msg","");
        return map;
    }

    @RequestMapping("/queryPricePage")
    @ResponseBody
    public Map<String,Object> queryPricePage(Houses houses){
        System.out.println("houses=="+houses);
        Map<String,Object> map = new HashMap<>();
        List<Map<String, Object>> maps = iHousesService.queryPricePage(houses.getPrice(),houses.gethType());

        map.put("data",maps);
        map.put("code",0);
        map.put("count",0);
        map.put("msg","");
        return map;
    }
    @RequestMapping("/queryPriceScopePage")
    @ResponseBody
    public Map<String,Object> queryPriceScopePage(Float price,Float price2){
        System.out.println(price);
        System.out.println(price2);
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = iHousesService.queryPriceScopePage(price, price2);

        map.put("data",maps);
        map.put("code",0);
        map.put("count",0);
        map.put("msg","");
        return map;
    }
}
