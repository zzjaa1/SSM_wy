package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.XiaoQu;
import com.zking.ssm_wy.Base.service.IBulidingService;
import com.zking.ssm_wy.Base.service.IHousesService;
import com.zking.ssm_wy.Base.service.IXiaoQuService;
import com.zking.ssm_wy.Base.vo.XiaoQuVo;
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
    public Map<String,Object> querytree(XiaoQu xiaoQu){
        Map<String,Object> map=new HashMap<>();
        List<Map<String,Object>> map3 =null;
        List<Map<String,Object>> map4 =null;
        List<Map<String,Object>> map5 =null;
        List<Map<String, Object>> queryxq = iXiaoQuService.queryxq(xiaoQu);
        if(queryxq.size()!=0){
            for (Map<String, Object> stringObjectMap : queryxq) {
                if (null!=stringObjectMap){
                    stringObjectMap.put("id",stringObjectMap.get("x_number").toString());
                    stringObjectMap.put("name",stringObjectMap.get("x_buliding").toString());
                    map3= iBulidingService.queryBulid(stringObjectMap.get("x_number").toString());
                    for (Map<String,Object> s : map3) {
                        if (null!=s){
                            s.put("id",s.get("b_number").toString());
                            s.put("name",s.get("b_buliding").toString());
                            map4 = iHousesService.queryHourse(s.get("b_number").toString());
                            for (Map<String,Object> objectMap : map4) {
                                if (null!=objectMap){
                                    objectMap.put("id",objectMap.get("h_number").toString());
                                    objectMap.put("name",objectMap.get("h_bulidingName").toString());
                                    map5=iHousesService.queryHourse(objectMap.get("h_number").toString());
                                    for (Map<String, Object> map6 : map5) {
                                        if (null!=map6){
                                            map6.put("id",map6.get("h_number").toString());
                                            map6.put("name",map6.get("h_bulidingName").toString());
                                        }
                                    }
                                    objectMap.put("children",map5);
                                }
                            }
                            s.put("children",map4);
                        }
                    }
                    stringObjectMap.put("children",map3);
                }
            }
        }

        map.put("li",queryxq);
        return map;
    }

    @RequestMapping("/queryweizi")
    @ResponseBody
    public Map<String,Object> queryweizi(XiaoQuVo xiaoQuVo){
        System.out.println("number"+xiaoQuVo);
        Map<String,Object> map=new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map1=new HashMap<>();

        List<Map<String, Object>> querysf = iXiaoQuService.querysf(xiaoQuVo);
        map.put("data",querysf);
        map.put("code",0);
        map.put("msg","");
        map.put("count",0);
        return map;
    }

    

}
