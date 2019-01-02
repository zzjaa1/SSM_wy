package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.model.Complaint;
import com.zking.ssm_wy.Base.service.ComplaintService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ComplainController {
    @Autowired
    private ComplaintService complaintService;
    @RequestMapping("/queryComplaintPage")
    @ResponseBody
    public Map<String,Object> queryComplaintPage(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = complaintService.queryComplaintPage(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =complaintService.queryComplaintPage(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryComplaint2Page")
    @ResponseBody
    public Map<String,Object> queryComplaint2Page(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = complaintService.queryComplaint2Page(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =complaintService.queryComplaint2Page(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryComplaint3Page")
    @ResponseBody
    public Map<String,Object> queryComplaint3Page(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = complaintService.queryComplaint3Page(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =complaintService.queryComplaint3Page(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryComplaint4Page")
    @ResponseBody
    public Map<String,Object> queryComplaint4Page(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = complaintService.queryComplaint4Page(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =complaintService.queryComplaint4Page(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/queryComplaint5Page")
    @ResponseBody
    public Map<String,Object> queryComplaint5Page(String cname,int page,int limit){
        System.out.println("cname=="+cname);
        cname="%"+cname+"%";
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = complaintService.queryComplaint5Page(cname,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps =complaintService.queryComplaint5Page(cname,pb);
        }
        map.put("data",maps);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pb.getTotal());
        map.put("page", page);
        return map;
    }
    @RequestMapping("/delComplaint")
    @ResponseBody
    public String delComplaint(int cid){
        complaintService.delComplaint(cid);
        return "成功";
    }
    @RequestMapping("/addComplaint")
    @ResponseBody
    public String addComplaint(Complaint complaint){
        complaintService.addComplaint(complaint);
        System.out.println("111");
        return "成功";
    }

}
