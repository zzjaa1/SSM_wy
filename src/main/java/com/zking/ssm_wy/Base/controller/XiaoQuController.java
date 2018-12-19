package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.service.IBulidingService;
import com.zking.ssm_wy.Base.service.IHousesService;
import com.zking.ssm_wy.Base.service.IXiaoQuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class XiaoQuController {

    @Autowired
    private IXiaoQuService iXiaoQuService;
    @Autowired
    private IBulidingService iBulidingService;
    @Autowired
    private IHousesService iHousesService;

    /**
     * 树形
     * @return
     */
    @RequestMapping("/querytree")
    @ResponseBody
    public Map<String,Object> querytree(){
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2 =new HashMap<>();
        List<Map<String,Object>> map3 =null;
        List<Map<String,Object>> map4 =null;
        List<Map<String,Object>> map5 =null;

        List<Map<String, Object>> queryxq = iXiaoQuService.queryxq();
        for (Map<String, Object> stringObjectMap : queryxq) {
            stringObjectMap.put("id",stringObjectMap.get("x_number").toString());
            stringObjectMap.put("name",stringObjectMap.get("x_buliding").toString());
            map3= iBulidingService.queryBulid(stringObjectMap.get("x_number").toString());
            System.out.println("map3="+map3);
            for (Map<String,Object> s : map3) {
                s.put("id",s.get("b_number").toString());
                s.put("name",s.get("b_buliding").toString());
                System.out.println(s.get("b_number").toString());
                map4 = iHousesService.queryHourse(s.get("b_number").toString());
                System.out.println("map4"+map4);
               for (Map<String,Object> objectMap : map4) {
                    objectMap.put("id",objectMap.get("h_number").toString());
                    objectMap.put("name",objectMap.get("h_bulidingName").toString());
                    map5=iHousesService.queryHourse(objectMap.get("h_number").toString());
                       for (Map<String, Object> map6 : map5) {
                               map6.put("id",map6.get("h_number").toString());
                               map6.put("name",map6.get("h_bulidingName").toString());
                           }
                    objectMap.put("children",map5);
                }
                s.put("children",map4);
            }
            stringObjectMap.put("children",map3);
        }
        map.put("li",queryxq);
        return map;
    }

    @RequestMapping("/queryweizi")
    @ResponseBody
    public Map<String,Object> queryweizi(){
        List<Map<String, Object>> querysf = iXiaoQuService.querysf();
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();

        String name="";
        for (Map<String, Object> map1 : querysf) {
            System.out.println(map1);
            if(null!=map1.get("x_buliding").toString()){
                name+=map1.get("x_buliding").toString();
            }
            if(null!=map1.get("b_buliding").toString()){
                name+="#"+map1.get("b_buliding").toString();
            }
         /*   if(map1.get("dym").toString().length()!=0){
                name+="#"+map1.get("dym").toString();
            }else {
                name+="";
            }*/
          if(map1.containsKey("dym")){
             name+="#"+map1.get("dym").toString();
          }
            System.out.println("name"+name);
//            map.put("mc",map1.get("x_buliding").toString()+
//                    "#"+map1.get("b_buliding").toString()+
//                    "#"+map1.get("dym").toString());
//            System.out.println(map);
            map2.put("mc",name);
        }

        map.put("li",map2);

        return map;
    }



}
