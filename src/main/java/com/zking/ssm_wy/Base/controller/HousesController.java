package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Buliding;
import com.zking.ssm_wy.Base.model.Houses;
import com.zking.ssm_wy.Base.service.IBulidingService;
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

    @Autowired
    private IBulidingService bulidingService;

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


    /**
     * 添加单元
     * @param houses
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertHouse")
    public Map<String,Object> insertHouse(Houses houses){
        String s = iHousesService.queryHourId();
        int d=Integer.parseInt(s)+1;
        houses.sethNumber(houses.getbNumber()+"-DY"+d);
        int updatequery = iHousesService.Updatequery(houses.getbNumber());
        Buliding buliding =new Buliding();
        buliding.setbUnitnumber(updatequery+1);
        buliding.setbNumber(houses.getbNumber());
        bulidingService.updateunitname(buliding);
        houses.sethUnitnumber(1);
        System.out.println(houses);
        int i = iHousesService.insertSelective(houses);

        Map<String,Object> map =new HashMap<>();
        map.put("homename",houses.gethBulidingname());
        map.put("bh",houses.gethNumber());
        map.put("success",true);
        map.put("msg","成功");
        return map;
    }

    /**
     * 添加房间
     * @param houses
     * @return
     */
    @RequestMapping("/inserthome")
    @ResponseBody
    public  Map<String,Object> inserthome(Houses houses){
        houses.sethNumber(houses.getbNumber()+"-S"+houses.gethBulidingname());
        houses.sethBulidingname(houses.gethBulidingname()+"室");
        String h= houses.getbNumber().substring(0,houses.getbNumber().lastIndexOf("-"));
        int updatequery = iHousesService.Updatequery(h);
        System.out.println(h);
        Buliding buliding =new Buliding();
        buliding.setbHoursnumber(updatequery+1);
        buliding.setbNumber(h);
        int update = bulidingService.update(buliding);
        System.out.println(houses);
        int i = iHousesService.insertSelective(houses);
        Map<String,Object> map =new HashMap<>();
        map.put("success",true);
        map.put("msg","成功");
        return map;
    }

}
