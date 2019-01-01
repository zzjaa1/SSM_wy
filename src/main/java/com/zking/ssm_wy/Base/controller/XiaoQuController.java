package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.XiaoQu;
import com.zking.ssm_wy.Base.service.IBulidingService;
import com.zking.ssm_wy.Base.service.IHousesService;
import com.zking.ssm_wy.Base.service.IXiaoQuService;
import com.zking.ssm_wy.Base.service.IcostnameService;
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

    @Autowired
    private IcostnameService icostnameService;

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
                    stringObjectMap.put("parant",stringObjectMap.get("name"));
                    map3= iBulidingService.queryBulid(stringObjectMap.get("x_number").toString());
                        for (Map<String,Object> s : map3) {
                        if (null!=s){
                            s.put("id",s.get("b_number").toString());
                            s.put("name",s.get("b_buliding").toString());
                            s.put("parant",stringObjectMap.get("parant")+"-"+s.get("name"));
                            map4 = iHousesService.queryHourse(s.get("b_number").toString());
                            for (Map<String,Object> objectMap : map4) {
                                if (null!=objectMap){
                                    objectMap.put("id",objectMap.get("h_number").toString());
                                    objectMap.put("name",objectMap.get("h_bulidingName").toString());
                                    objectMap.put("parant",s.get("parant")+"-"+objectMap.get("name"));
                                    map5=iHousesService.queryHourse(objectMap.get("h_number").toString());
                                    for (Map<String, Object> map6 : map5) {
                                        if (null!=map6){
                                            map6.put("id",map6.get("h_number").toString());
                                            map6.put("name",map6.get("h_bulidingName").toString());
                                            map6.put("parant",objectMap.get("parant")+"-"+map6.get("name"));
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
            }}
        map.put("li",queryxq);
        System.out.println("map======"+queryxq);
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

    /**
     * 树形 Bootstraptree
     * @return
     */
    @RequestMapping("/queryBootstraptree")
    @ResponseBody
    public Map<String,Object> queryBootstraptree(XiaoQu xiaoQu){
        Map<String,Object> map=new HashMap<>();
        List<Map<String,Object>> map3 =null;
        List<Map<String,Object>> map4 =null;
        List<Map<String,Object>> map5 =null;
        List<Map<String, Object>> queryxq = iXiaoQuService.queryxq(xiaoQu);
        if(queryxq.size()!=0){
            for (Map<String, Object> stringObjectMap : queryxq) {
                if (null!=stringObjectMap){
                    stringObjectMap.put("id",stringObjectMap.get("x_number").toString());
                    stringObjectMap.put("text",stringObjectMap.get("x_buliding").toString());
                    stringObjectMap.put("icon", "glyphicon glyphicon-th");
                    stringObjectMap.put("tags", Arrays.asList(new String[]{
                            "楼宇数:"+stringObjectMap.get("x_xuliding").toString(),
                         /*   "单元数:"+stringObjectMap.get("x_unitNumber").toString(),
                            "楼层数:"+stringObjectMap.get("x_Nuberj").toString(),*/
                            "房屋数:"+stringObjectMap.get("x_hoursNumber").toString(),
                            stringObjectMap.get("x_mj").toString()+"㎡"}));
                    map3= iBulidingService.queryBulid(stringObjectMap.get("x_number").toString());
                    for (Map<String,Object> s : map3) {
                        if (null!=s){
                            s.put("id",s.get("b_number").toString());
                            s.put("text",s.get("b_buliding").toString());
                            s.put("icon", "glyphicon glyphicon-stop");
                            s.put("tags", Arrays.asList(new String[]{
                                    "单元数:"+s.get("b_unitNumber").toString(),
                                    "楼层数:"+s.get("b_Nuberj").toString(),
                                    "房屋数:"+s.get("b_hoursNumber").toString()}));
                            map4 = iHousesService.queryHourse(s.get("b_number").toString());
                            for (Map<String,Object> objectMap : map4) {
                                if (null!=objectMap){
                                    objectMap.put("id",objectMap.get("h_number").toString());
                                    objectMap.put("text",objectMap.get("h_bulidingName").toString());
                                    objectMap.put("icon", "glyphicon glyphicon-share-alt");
                                    objectMap.put("tags", Arrays.asList(new String[]{
                                            objectMap.get("h_bulidingName").toString()}));
                                    map5=iHousesService.queryHourse(objectMap.get("h_number").toString());
                                    for (Map<String, Object> map6 : map5) {
                                        if (null!=map6){
                                            map6.put("id",map6.get("h_number").toString());
                                            map6.put("text",map6.get("h_bulidingName").toString());
                                            map6.put("icon", "glyphicon glyphicon-home");
                                            map6.put("tags", Arrays.asList(new String[]{
                                                    map6.get("h_type").toString(),
                                                    map6.get("h_direction").toString(),
                                                    map6.get("h_area").toString()+"㎡"}));
                                            map6.put("nodes", "");
                                        }
                                    }
                                    objectMap.put("nodes",map5);
                                }
                            }
                            s.put("nodes",map4);
                        }
                    }
                    stringObjectMap.put("nodes",map3);
                }
            }
        }
        List<Map<String, Object>> maps = icostnameService.queryName();
        for (Map<String, Object> stringObjectMap : maps) {
            stringObjectMap.put("id",stringObjectMap.get("cn_id").toString());
            stringObjectMap.put("text",stringObjectMap.get("cn_name").toString());
            stringObjectMap.put("icon", "glyphicon glyphicon-folder-open");
            stringObjectMap.put("tags", Arrays.asList(new String[]{
                    stringObjectMap.get("cn_type").toString(),
                    "每过"+stringObjectMap.get("cn_cycle").toString()+"月缴费"}));
        }
        List<Map<String, Object>> lis=new ArrayList<>();
        Map<String, Object> ma=new HashMap<>();
        ma.put("id","fyxx");
        ma.put("text","费用信息");
        ma.put("nodes",maps);
        lis.add(ma);
        map.put("li",queryxq);
        map.put("lis",lis);
        return map;
    }


    @RequestMapping("/insertXiaoqu")
    @ResponseBody
    public Map<String,Object> insertXiaoqu(XiaoQu xiaoQu){
        System.out.println(xiaoQu);

        String s = iXiaoQuService.queryXId();
        int d=Integer.parseInt(s)+1;
        xiaoQu.setxNumber("XQ"+d);
        int i = iXiaoQuService.insertSelective(xiaoQu);

        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        map.put("msg","成功");

        return map;
    }


    @ResponseBody
    @RequestMapping("/selectXiaoqu")
    public Map<String,Object> selectXiaoqu(){
        List<Map<String, Object>> queryxq = iXiaoQuService.queryxq(null);
        Map<String,Object> map =new HashMap<>();
        map.put("data",queryxq);
        return map;
    }

}
