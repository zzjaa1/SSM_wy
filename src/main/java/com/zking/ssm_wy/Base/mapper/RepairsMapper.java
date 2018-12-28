package com.zking.ssm_wy.Base.mapper;

import java.util.List;
import java.util.Map;

public interface RepairsMapper {
    List<Map<String,Object>> queryRepairsPage(String cname);

    List<Map<String,Object>> queryRepairs2Page(String cname);

    List<Map<String,Object>> queryRepairs3Page(String cname);

    List<Map<String,Object>> queryRepairs4Page(String cname);

    List<Map<String,Object>> queryRepairs5Page(String cname);

    String delRepairs(int cid);
}
