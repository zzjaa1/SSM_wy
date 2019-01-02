package com.zking.ssm_wy.Base.controller;

import com.github.pagehelper.PageHelper;
import com.zking.ssm_wy.Base.model.Cost;
import com.zking.ssm_wy.Base.service.ICostService;
import com.zking.ssm_wy.Base.service.IHousesService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class sfController {
    @Autowired
    private ICostService iCostService;

    @Autowired
    private IHousesService iHousesService;
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
          /*  map.put("c_scfyzq_date",map.get("c_scfyzq_date").toString());*/
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
    public Map<String, Object> sczd(@RequestBody List<Map<String,Object>> li) throws ParseException {
        Map<String,Object> map =new HashMap<>();
        String c_bcfyqq_date = li.get(0).get("c_bcfyqq_date").toString();
        String c_bcfyzq_date = li.get(0).get("c_bcfyzq_date").toString();
        List<Map<String, Object>> queryrq = iCostService.queryrq(c_bcfyqq_date, c_bcfyzq_date);
        List<Map<String, Object>> maps = iHousesService.queryCfcCost();//c_fc
        List<Map<String, Object>> insert = new ArrayList<>();//插入
        int han=0;
        int sbhan=0;
        int max=0;
        System.out.println("rq="+queryrq.toString());
        if(queryrq.toString()=="[]"){
            System.out.println("无冲突");
            for (Map<String, Object> stringObjectMap : li) {
                for (Map<String, Object> s :maps) {
                    if(s.get("h_number").toString().equals(stringObjectMap.get("h_number").toString())){
                        stringObjectMap.put("c_fc",s.get("c_fc"));
                        han++;
                        max++;
                    }
                }
                int a = iCostService.MaxCostNumber();
                stringObjectMap.put("c_number",maxNumber(a+max));
            }
            iCostService.InsetsCost(li);
            map.put("han",han);
            map.put("sbhan",0);
        }else{
            System.out.println("冲突");
            sbhan=0;//冲突行
            List<Map<String,Object>> sbsjy=new ArrayList<>();
            List<Map<String,Object>> sbsj=new ArrayList<>();
            for (Map<String, Object> lis : li) {
                    int i=1;
                    for (Map<String, Object> rq : queryrq) {
                    if(rq.get("cn_id").equals(lis.get("cn_id"))&&rq.get("h_number").equals(lis.get("h_number"))){
                        i=0;
                        sbhan++;
                        rq.put("c_bcfyqq_date",rq.get("c_bcfyqq_date").toString());
                        rq.put("c_bcfyzq_date",rq.get("c_bcfyzq_date").toString());
                        rq.put("c_bcjfzq_date",rq.get("c_bcjfzq_date").toString());
                        sbsjy.add(rq);
                        sbsj.add(lis);
                        System.out.println("冲突行："+sbhan);
                    }
                }
                if(i>0){
                    System.out.println("执行");
                    for (Map<String, Object> s :maps) {
                        if(lis.get("h_number").toString().equals(s.get("h_number").toString())){
                            lis.put("c_fc",s.get("c_fc"));
                            han++;
                        }
                    }
                    int a = iCostService.MaxCostNumber();
                    max++;
                    lis.put("c_number",maxNumber(a+max));
                    insert.add(lis);
                    }
            }
            if(insert.toString()!="[]"){
                iCostService.InsetsCost(insert);
            }

            map.put("sbsjy",sbsjy);
            map.put("sbsj",sbsj);
            map.put("han",han);
            map.put("sbhan",sbhan);
        }

        return map;
    }

    public String maxNumber(int a){
        Map<String,Object> map=new HashMap<>();
        System.out.println("int="+a);
        String s="C";
        int cd = String.valueOf(a+1).length();
        for(int i=0;i<9-cd;i++){
            s+="0";
        }
        s+=a+1;
        return s;
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
        String[] s={"c_fc","cn_suer","c_costName","c_jfdw","c_dwjg","c_real","c_yjfy","c_bcfyqq_date","c_bcfyzq_date"
                ,"c_bcjfzq_date","cn_cycle","cn_id","h_number"};
        CommonsMultipartFile cFile = (CommonsMultipartFile) file;
        DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
        InputStream inputStream = fileItem.getInputStream();
        List<Map<String, Object>> maps = ex.readCaseFile(inputStream, 1, s);
        int sbhan=0;
        int han=0;
        int max=0;
        List<Map<String, Object>> queryrq = iCostService.queryrq(maps.get(0).get("c_bcfyqq_date").toString(),
                maps.get(0).get("c_bcfyzq_date").toString());
        List<Map<String,Object>> sbsjy=new ArrayList<>();
        List<Map<String,Object>> sbsj=new ArrayList<>();
        List<Map<String, Object>> insert = new ArrayList<>();//插入
        for (Map<String, Object> lis : maps) {
            int i=1;
            for (Map<String, Object> rq : queryrq) {
                System.out.println("rq="+rq.toString());
                if(rq.get("cn_id").toString().equals(lis.get("cn_id").toString())&&rq.get("h_number").toString().equals(lis.get("h_number").toString())){
                    i=0;
                    sbhan++;
                    rq.put("c_bcfyqq_date",rq.get("c_bcfyqq_date").toString());
                    rq.put("c_bcfyzq_date",rq.get("c_bcfyzq_date").toString());
                    rq.put("c_bcjfzq_date",rq.get("c_bcjfzq_date").toString());
                    sbsjy.add(rq);
                    sbsj.add(lis);
                    System.out.println("冲突行："+sbhan);
                }
            }
            if(i>0){
                System.out.println("执行");
                han++;
                max++;
                int a = iCostService.MaxCostNumber();
                lis.put("c_number",maxNumber(a+max));
                insert.add(lis);
            }
        }
        if(insert.toString()!="[]") {
            iCostService.InsetsCost(insert);
        }
        // 判断文件大小、即名称
        long size = file.getSize();
        map.put("han",han);
        map.put("sbhan",sbhan);
        map.put("sbsj",sbsj);
        map.put("sbsjy",sbsjy);
        map.put("success","成功");
        return map;
    }

    /**
     * 替换
     */
    @RequestMapping("/thCost")
    @ResponseBody
    public Map<String, Object> thCost(@RequestBody List<Map<String,Object>> li) throws IOException {
        Map<String,Object> map =new HashMap<>();
        // 判断文件名是否为空
        iCostService.updateth(li);
        map.put("success","成功");
        return map;
    }


    @RequestMapping("/ExcelFY")
    @ResponseBody
    public Map<String, Object> ExcelFY(@RequestParam MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map =new HashMap<>();
        // 判断文件名是否为空
        if (file == null)
            return null;
        // 获取文件名
        String name = file.getOriginalFilename();
        ExcelUtils ex=new ExcelUtils();
        String[] s={"c_number","c_remarks"};
        CommonsMultipartFile cFile = (CommonsMultipartFile) file;
        DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
        InputStream inputStream = fileItem.getInputStream();
        List<Map<String, Object>> maps = ex.readCaseFile(inputStream, 1, s);
        List<Map<String, Object>> maps1 = iCostService.queryJfCost(maps);
        // 判断文件大小、即名称
        for (Map<String, Object> stringObjectMap : maps1) {
            stringObjectMap.put("c_bcfyqq_date",stringObjectMap.get("c_bcfyqq_date").toString());
            stringObjectMap.put("c_bcfyzq_date",stringObjectMap.get("c_bcfyzq_date").toString());
            stringObjectMap.put("c_bcjfzq_date",stringObjectMap.get("c_bcjfzq_date").toString());
            for (Map<String, Object> stringObjectMaps : maps) {
                if(stringObjectMaps.get("c_number").toString().equals(stringObjectMap.get("c_number").toString())){
                    stringObjectMap.put("c_remarks",stringObjectMaps.get("c_remarks").toString());
                }
            }

        }
        long size = file.getSize();
        map.put("li",maps1);
        map.put("success","成功");
        return map;
    }


    @RequestMapping("/JFJS")
    @ResponseBody
    public Map<String, Object> JFJS(@RequestBody List<Map<String,Object>> li) throws IOException {
        Map<String,Object> map =new HashMap<>();
        iCostService.UpdateJsDD(li);
        map.put("success","成功");
        return map;
    }
}
