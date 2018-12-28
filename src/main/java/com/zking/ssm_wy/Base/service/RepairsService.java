package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.util.PageBean;

import java.util.List;
import java.util.Map;

public interface RepairsService {
    List<Map<String,Object>> queryRepairsPage(String cname, PageBean pb);

    List<Map<String,Object>> queryRepairs2Page(String cname, PageBean pb);

    List<Map<String,Object>> queryRepairs3Page(String cname, PageBean pb);

    List<Map<String,Object>> queryRepairs4Page(String cname, PageBean pb);

    List<Map<String,Object>> queryRepairs5Page(String cname, PageBean pb);

    String delRepairs(int cid);
}
