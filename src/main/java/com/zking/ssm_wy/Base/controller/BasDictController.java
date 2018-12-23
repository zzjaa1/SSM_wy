package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.model.basDict;
import com.zking.ssm_wy.Base.model.CostName;
import com.zking.ssm_wy.Base.service.IbasDictService;
import com.zking.ssm_wy.Base.service.IcostnameService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public Map<String,Object> query(basDict basdict){
        Map<String,Object> result=new HashMap<>();
        List<Map<String,Object>> li=ibasDictService.querybasDict(basdict);
        result.put("data", li);
        return result;
    }




}
