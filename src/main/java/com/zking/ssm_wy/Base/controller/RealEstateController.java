package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.model.CostName;
import com.zking.ssm_wy.Base.model.RealEstate;
import com.zking.ssm_wy.Base.service.IHousesService;
import com.zking.ssm_wy.Base.service.IRealEstateService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class RealEstateController {
    @Autowired
    private IRealEstateService iRealEstateService;

    @Autowired
    private IHousesService iHousesService;

    @RequestMapping("/queryRealEstatePage")
    @ResponseBody
    public Map<String,Object> queryRealEstatePage(RealEstate realEstate, HttpServletRequest req, int page, int limit){
        // List<Map<String, Object>> querytj = iRealEstateService.querytj(year);
        PageBean pb=new PageBean();
        pb.setPage(page);
        pb.setRows(limit);
        if(null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        List<Map<String, Object>> querytj = iRealEstateService.queryRealEstatePage(realEstate);
        int a=pb.getTotal()/pb.getRows();
        if(a+1<page){
            pb.setPage(a+1);
            querytj = iRealEstateService.queryRealEstatePage(realEstate);
        }
        for (Map<String, Object> map : querytj) {
            map.put("Re_date", map.get("Re_date").toString());
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", querytj);
        result.put("code", 0);
        result.put("msg","");
        result.put("count",pb.getTotal());
        result.put("page", page);
        return result;
    }

    @RequestMapping("/addReall")
    @ResponseBody
    public  Map<String,Object> addReall(RealEstate realEstate,String rz){
        Map<String,Object> map=new HashMap<>();
        iRealEstateService.addReal(realEstate);
        iHousesService.UpdateState(realEstate.getHnumber(),"未入住");
        map.put("success","成功");
        return map;
    }


    @RequestMapping("/querytj")
    @ResponseBody
    public Map<String,Object> querytj(String year){
        Map<String,Object> map2=new HashMap<>();
//        List<Map<String, Object>> querytj = iRealEstateService.querytj();
//        System.out.println(querytj);
       // List<Map<String, Object>> querytj = iRealEstateService.querytj(year);
        Map<String,Object> map1=new HashMap<>();
        List<Map<String, Object>> querytj = iRealEstateService.querytj(year);
        map1.put("li",querytj);
        return map1;
    }

    /**
     * 合同编号处理
     * @param year
     * @return
     */
    @RequestMapping("/htbh")
    @ResponseBody
    public Map<String,Object> htbh(String year){
        Map<String,Object> map1=new HashMap<>();
        int a = iRealEstateService.queryHtbh();
        String s="RE";
        int cd = String.valueOf(a).length();
        System.out.println("cd===="+cd);
        for(int i=0;i<9-cd;i++){
            s+="0";
        }
        s+=a+1;
        System.out.println("s="+s);
        map1.put("htbh",s);
        return map1;
    }

    @ResponseBody
    @RequestMapping("/queryxqxseTj")
    public Map<String,Object> queryxqxseTj(String year){
        System.out.println("--------"+year);
        List<Map<String, Object>> queryxsetj = iRealEstateService.queryxsetj(year);
       Map<String,Object> map =new HashMap<>();
       map.put("rows",queryxsetj);
        return map;
    }

    @ResponseBody
    @RequestMapping("/queryxqxseTj2")
    public  List<Map<String, Object>> queryxqxseTj2(String year,String x_number ,String mouth){

        List<Map<String, Object>> maps = iRealEstateService.queryxsetj2(year, x_number, mouth);

        return maps;
    }

}
