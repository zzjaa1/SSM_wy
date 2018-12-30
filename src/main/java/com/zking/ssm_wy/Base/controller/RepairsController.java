package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.service.ComplaintService;
import com.zking.ssm_wy.Base.service.RepairsService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RepairsController {
    @Autowired
    private RepairsService repairsService;
    @RequestMapping("/queryRepairsPage")
    @ResponseBody
    public Map<String,Object> queryRepairsPage(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = repairsService.queryRepairsPage(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =repairsService.queryRepairsPage(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryRepairs2Page")
    @ResponseBody
    public Map<String,Object> queryRepairs2Page(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = repairsService.queryRepairs2Page(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =repairsService.queryRepairs2Page(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryRepairs3Page")
    @ResponseBody
    public Map<String,Object> queryRepairs3Page(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = repairsService.queryRepairs3Page(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =repairsService.queryRepairs3Page(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryRepairs4Page")
    @ResponseBody
    public Map<String,Object> queryRepairs4Page(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = repairsService.queryRepairs4Page(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =repairsService.queryRepairs4Page(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryRepairs5Page")
    @ResponseBody
    public Map<String,Object> queryRepairs5Page(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = repairsService.queryRepairs5Page(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =repairsService.queryRepairs5Page(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }
    @RequestMapping("/deRepairs")
    @ResponseBody
    public String deRepairs(int cid){
        repairsService.delRepairs(cid);
        return "成功";
    }

}
