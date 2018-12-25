package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.model.CostName;
import com.zking.ssm_wy.Base.service.ISysPermissionService;
import com.zking.ssm_wy.Base.service.IcostnameService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/costName")
public class CostNameController {

    @Autowired
    private IcostnameService icostnameService;

    @RequestMapping("/queryCostName")
    @ResponseBody
    public Map<String,Object> query(HttpServletRequest req,CostName costn, int page, int limit){
        PageBean pb=new PageBean();
            pb.setPage(page);
            pb.setRows(limit);
        costn.setCnName("%"+costn.getCnName()+"%");
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        List<Map<String, Object>> maps = icostnameService.queryCostNamePage(costn, pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            maps = icostnameService.queryCostNamePage(costn, pb);
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("count",pb.getTotal());
        result.put("data", maps);
        result.put("page", page);
        return result;
    }


    @RequestMapping("/updCostName")
    @ResponseBody
    public Map<String,Object> updates(CostName c){
        Map<String, Object> result = new HashMap<String, Object>();
        int i = icostnameService.updateByPrimaryKeySelective(c);
        result.put("success", "保存成功");
        return result;
    }

    @RequestMapping("/delCostName")
    @ResponseBody
    public Map<String,Object> del(CostName c){
        Map<String, Object> result = new HashMap<String, Object>();
        int i = icostnameService.deleteByPrimaryKey(c.getCnId());
        result.put("success", "保存成功");
        return result;
    }

    @RequestMapping("/addCostName")
    @ResponseBody
    public Map<String,Object> add(CostName c){
        Map<String, Object> result = new HashMap<String, Object>();
        int i = icostnameService.insert(c);
        result.put("success", "保存成功");
        return result;
    }

    @RequestMapping("/queryCostname")
    @ResponseBody
    public Map<String,Object> queryCostname(){
        List<Map<String, Object>> maps = icostnameService.queryName();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("data",maps);
        return map;
    }
}
