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

    @RequestMapping("/sczd")
    @ResponseBody
    public Map<String, Object> sczd(@RequestBody List<Map<String,Object>> li){
        Map<String,Object> map =new HashMap<>();
        String c_bcfyqq_date = li.get(0).get("c_bcfyqq_date").toString();
        String c_bcfyzq_date = li.get(0).get("c_bcfyzq_date").toString();
        List<Map<String, Object>> queryrq = iCostService.queryrq(c_bcfyqq_date, c_bcfyzq_date);
        if(queryrq==null){
            map.put("han",0);
        }else{
            int han=0;//冲突行
            List<Map<String,Object>> sbsjy=new ArrayList<>();
            List<Map<String,Object>> sbsj=new ArrayList<>();
            for (Map<String, Object> rq : queryrq) {
                System.out.println("cn_id="+rq.get("cn_id")+"h_number="+rq.get("h_number"));
                for (Map<String, Object> lis : li) {
                    System.out.println("cn_id="+lis.get("cn_id")+"h_number="+lis.get("h_number"));
                    if(rq.get("cn_id").equals(lis.get("cn_id"))&&rq.get("h_number").equals(lis.get("h_number"))){
                        han++;
                        sbsjy.add(rq);
                        sbsj.add(lis);
                    }
                }
            }
            map.put("sbsjy",sbsjy);
            map.put("sbsj",sbsjy);
            map.put("han",han);
        }

        return map;
    }
}
