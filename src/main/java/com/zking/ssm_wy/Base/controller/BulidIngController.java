package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Buliding;
import com.zking.ssm_wy.Base.service.IBulidingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/BulidIng")
public class BulidIngController {

    @Autowired
    private IBulidingService iBulidingService;

    @RequestMapping("/insertBulid")
    @ResponseBody
    public Map<String,Object> insertBulid(Buliding buliding){
        System.out.println("123========"+buliding);
        String s = iBulidingService.QueryId();
        int id= Integer.parseInt(s)+1;
        buliding.setbNumber(buliding.getxNumber()+"-B"+id);
        int i = iBulidingService.insertSelective(buliding);
        Map<String,Object> map=new HashMap<>();
        map.put("bnumber",buliding.getbNumber());
        map.put("xbuliding",buliding.getbBuliding());
        map.put("success",true);
        map.put("msg","成功");
        return map;
    }
    @RequestMapping("/updateBulid")
    @ResponseBody
    public Map<String,Object> updateBulid(Buliding buliding){
        System.out.println(buliding);
        int i = iBulidingService.updateByPrimaryKeySelective(buliding);
        Map<String,Object> map =new HashMap<>();
        map.put("msg","编辑成功");
        map.put("success",true);
        return map;
    }


    @RequestMapping("/queryB")
    @ResponseBody
    public Map<String,Object> queryB(Buliding buliding){
        System.out.println(buliding);
        List<Map<String, Object>> maps = iBulidingService.queryB(buliding);
        Map<String,Object> map =new HashMap<>();
        map.put("data",maps);
        map.put("success",true);
        return map;
    }

}
