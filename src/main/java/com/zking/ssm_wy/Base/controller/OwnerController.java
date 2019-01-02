package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Owner;
import com.zking.ssm_wy.Base.service.IOwnerService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OwnerController {
    @Autowired
    private IOwnerService iOwnerService;
    @RequestMapping("/queryOwner")
    @ResponseBody
    public Map<String,Object> queryOwner(String oname){
        System.out.println("name="+oname);
        if(oname!=null){
            oname="%"+oname+"%";
        }
        Map<String,Object> map=new HashMap<>();
        List<Map<String, Object>> maps = iOwnerService.queryOwner(oname);
        map.put("data",maps);
        map.put("code",0);
        map.put("count",0);
        map.put("msg","");
        return map;
    }

    @RequestMapping("/queryPage")
    @ResponseBody
    public Map<String,Object> queryPage(String o_name ,String h_number, int page, int limit, HttpServletRequest request){
        PageBean pageBean =new PageBean();
       pageBean.setPage(page);
       pageBean.setRows(limit);
       pageBean.setRequest(request);
      /*  List<Map<String, Object>> maps = iOwnerService.queryowenPage(o_name,h_number, pageBean);*/
        Map<String,Object> map=new HashMap<>();
        map.put("data","");
        map.put("code",0);
        map.put("count",pageBean.getTotal());
        map.put("msg","");
        return map;
    }

    @ResponseBody
    @RequestMapping("/Updateowener")
    public Map<String,Object> Updateowener(Owner owner){
        System.out.println(owner);
        int i = iOwnerService.UpdateOwen(owner);
        Map<String,Object> map=new HashMap<>();
        map.put("msg","成功");
        map.put("success",true);

        return map;
    }

    @ResponseBody
    @RequestMapping("/Deleteowener")
    public Map<String,Object> Deleteowener(String Onumber){
        System.out.println(Onumber);
        int i = iOwnerService.deleteOwen(Onumber);
        Map<String,Object> map=new HashMap<>();
        map.put("msg","成功");
        map.put("success",true);
        return map;
    }

    @ResponseBody
    @RequestMapping("/maxNumber")
    public Map<String,Object> maxNumber(String Onumber){
        Map<String,Object> map=new HashMap<>();
        int a = iOwnerService.maxNumber();
        String s="OW";
        int cd = String.valueOf(a).length();
        for(int i=0;i<9-cd;i++){
            s+="0";
        }
        s+=a+1;
        map.put("max",s);
        map.put("success",true);
        return map;
    }


    @ResponseBody
    @RequestMapping("/addOwner")
    public Map<String,Object> addOwner(Owner owner){
        Map<String,Object> map=new HashMap<>();
        System.out.println("owner="+owner);
        iOwnerService.addOwner(owner);
        map.put("success",1);
        return map;
    }

}
