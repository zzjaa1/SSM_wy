package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.model.Houses;
import com.zking.ssm_wy.Base.service.IHousesService;
import com.zking.ssm_wy.Base.util.PageBean;
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

    @RequestMapping("/queryBulidingNamePage")
    @ResponseBody
    public Map<String,Object> queryBulidingNamePage(Houses houses,int page,int limit){
        System.out.println(houses.gethBulidingname());
        houses.sethBulidingname("%"+houses.gethBulidingname()+"%");
        System.out.println("bulidingName="+houses.gethBulidingname());
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map =new HashMap<>();
        List<Map<String, Object>> maps = iHousesService.queryBulidingNamePage(houses.gethBulidingname(),pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =iHousesService.queryBulidingNamePage(houses.gethBulidingname(),pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryStatePage")
    @ResponseBody
    public Map<String,Object> queryStatePage(Houses houses,int page,int limit){

        houses.sethBulidingname("%"+houses.gethBulidingname()+"%");
        String bulidingname=houses.gethBulidingname();
        System.out.println("queryState"+houses.gethState());
        System.out.println("queryState"+houses.gethBulidingname());
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = iHousesService.queryStatePage(bulidingname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =iHousesService.queryStatePage(bulidingname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryPricePage")
    @ResponseBody
    public Map<String,Object> queryPricePage(Houses houses,int page,int limit){
        System.out.println("houses=="+houses);
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map = new HashMap<>();
        List<Map<String, Object>> maps = iHousesService.queryPricePage(houses.getPrice(),houses.gethType(),pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =iHousesService.queryPricePage(houses.getPrice(),houses.gethType(),pb);
        }

        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }
    @RequestMapping("/queryPriceScopePage")
    @ResponseBody
    public Map<String,Object> queryPriceScopePage(Float price,Float price2,int page,int limit){
        System.out.println(price);
        System.out.println(price2);
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = iHousesService.queryPriceScopePage(price, price2,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps=iHousesService.queryPriceScopePage(price, price2,pb);
        }

        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }
}
