package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.model.Cost;
import com.zking.ssm_wy.Base.service.ICostService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class sfController {
    @Autowired
    private ICostService iCostService;

    @RequestMapping("/queryCost")
    @ResponseBody
    public Map<String, Object> queryCost(HttpServletRequest req,int page,int limit,String qq,String zq,String fj,String fy){
        List<String> lifj = null;
        List<String> lify = null;
        if(fj!=null) {
            String[] split = fj.split(",");
           lifj = Arrays.asList(split);
            if(lifj.get(0)==""){
                lifj=null;
            }
        }

        if(fy!=null) {
            String[] splits = fy.split(",");
            lify = Arrays.asList(splits);
            if(lify.get(0)==""){
                lify=null;
            }
        }

        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        List<Map<String, Object>> maps = iCostService.queryCostfwPage(lifj,qq, zq, lify,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps=iCostService.queryCostfwPage(lifj, qq, zq, lify,pb);
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data",maps);
        result.put("code",0);
        result.put("msg","");
        result.put("count",pb.getTotal());
        result.put("page", page);
        return  result;
    }

    @RequestMapping("/queryCostss")
    @ResponseBody
    public Map<String, Object> queryCost(int page, HttpServletRequest req){
        String[] carrier = req.getParameterValues("li");
        for (String s : carrier) {
            System.out.println(s);
        }
        System.out.println("page="+page);
        /*for (Object o : li) {
            System.out.println("ss="+o.toString());
        }*/
        Map<String,Object> map =new HashMap<>();
        return map;
    }
}
