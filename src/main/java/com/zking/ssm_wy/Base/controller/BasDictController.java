package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.model.basDict;
import com.zking.ssm_wy.Base.model.CostName;
import com.zking.ssm_wy.Base.service.IbasDictService;
import com.zking.ssm_wy.Base.service.IcostnameService;
import com.zking.ssm_wy.Base.util.PageBean;
import com.zking.ssm_wy.annotation.SystemControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basDict")
public class BasDictController {

    @Autowired
   private IbasDictService ibasDictService;

    @RequestMapping("/querybasDict")
    @ResponseBody

    //日志注解Controller
    @SystemControllerLog(description = "查询费项")
    public Map<String,Object> query(basDict basdict){
        Map<String,Object> result=new HashMap<>();
        List<Map<String,Object>> li=ibasDictService.querybasDict(basdict);
        result.put("data", li);
        return result;
    }

    @RequestMapping("/delbasDict")
    @ResponseBody
    public Map<String,Object> delbasDict(basDict basdict){
        Map<String,Object> result=new HashMap<>();
        int i = ibasDictService.deleteByPrimaryKey(basdict.getDictId());
        if(i==1){
            result.put("success", "成功");
        }else{
            result.put("success", "失败");
        }
        return result;
    }

    @RequestMapping("/addbasDict")
    @ResponseBody
    public Map<String,Object> addbasDict(basDict basdict){
        Map<String,Object> result=new HashMap<>();
        int i = ibasDictService.insertSelective(basdict);
        if(i==1){
            result.put("success", "成功");
        }else{
            result.put("success", "失败");
        }
        return result;
    }
    @RequestMapping("/updbasDict")
    @ResponseBody
    public Map<String,Object> updbasDict(basDict basdict){
        Map<String,Object> result=new HashMap<>();
        int i = ibasDictService.updateByPrimaryKeySelective(basdict);
        if(i==1){
            result.put("success", "成功");
        }else{
            result.put("success", "失败");
        }
        return result;
    }

    @RequestMapping("/updbasDictpl")
    @ResponseBody
    public Map<String,Object> updbasDictpl(@RequestBody List<Map<String,Object>> li){
        for (Map<String, Object> stringObjectMap : li) {
            System.out.println(stringObjectMap);
        }
        Map<String,Object> result=new HashMap<>();
       ibasDictService.updpl(li);
        result.put("success", "成功");
        return result;
    }

    @RequestMapping("/delbasDictpl")
    @ResponseBody
    public Map<String,Object> delbasDictpl(@RequestBody List<Map<String,Object>> li){
        Map<String,Object> result=new HashMap<>();
        ibasDictService.delpl(li);
            result.put("success", "成功");
        return result;
    }

    @RequestMapping("/querybasDictPage")
    @ResponseBody
    public Map<String,Object> querybasDictPage(basDict basdict,int page,int limit){
        Map<String,Object> result=new HashMap<>();
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        basdict.setDictType("%"+basdict.getDictType()+"%");
        List<Map<String,Object>> li=ibasDictService.querybasDictPage(basdict,pb);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            li=ibasDictService.querybasDictPage(basdict,pb);
        }
        result.put("code",0);
        result.put("data",li);
        result.put("msg","");
        result.put("count",pb.getTotal());
        result.put("page", page);
        return result;
    }


}
