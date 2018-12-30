package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.model.Cost;
import com.zking.ssm_wy.Base.service.ICostService;
import com.zking.ssm_wy.Base.util.ExcelUtils;
import com.zking.ssm_wy.Base.util.PageBean;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        for (Map<String, Object> map : maps) {
            map.put("c_scfyzq_date",map.get("c_scfyzq_date").toString());
            map.put("c_bcfyqq_date",map.get("c_bcfyqq_date").toString());
            map.put("c_bcfyzq_date",map.get("c_bcfyzq_date").toString());
            map.put("c_bcjfzq_date",map.get("c_bcjfzq_date").toString());
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
                for (Map<String, Object> lis : li) {
                    if(rq.get("cn_id").equals(lis.get("cn_id"))&&rq.get("h_number").equals(lis.get("h_number"))){
                        han++;
                        rq.put("c_bcfyqq_date",rq.get("c_bcfyqq_date").toString());
                        rq.put("c_bcfyzq_date",rq.get("c_bcfyzq_date").toString());
                        rq.put("c_bcjfzq_date",rq.get("c_bcjfzq_date").toString());
                        sbsjy.add(rq);
                        sbsj.add(lis);
                    }
                }
            }
            map.put("sbsjy",sbsjy);
            map.put("sbsj",sbsj);
            map.put("han",li.size()-han);
            map.put("sbhan",han);
        }

        return map;
    }

    @RequestMapping("/ExcelDR")
    @ResponseBody
    public Map<String, Object> ExcelDR(@RequestParam MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map =new HashMap<>();
        // 判断文件名是否为空
        if (file == null)
            return null;
        // 获取文件名
        String name = file.getOriginalFilename();
        ExcelUtils ex=new ExcelUtils(); //c_user, cn_name, c_jfdw, c_dwjg, c_real, c_yjfy, c_bcfyqq_date, c_bcfyzq_date, c_bcjfzq_date, cn_cycle
        String[] s={"c_fc","cn_suer","cn_name","c_jfdw","c_dwjg","c_real","c_yjfy","c_bcfyqq_date","c_bcfyzq_date"
                ,"c_bcjfzq_date","cn_cycle"};
        CommonsMultipartFile cFile = (CommonsMultipartFile) file;
        DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
        InputStream inputStream = fileItem.getInputStream();
        List<Map<String, Object>> maps = ex.readCaseFile(inputStream, 1, s);
        for (Map<String, Object> stringObjectMap : maps) {
            System.out.println("ss="+stringObjectMap);
        }
        // 判断文件大小、即名称
        long size = file.getSize();
        map.put("data",maps);
        map.put("success","成功");
        return map;
    }
}
