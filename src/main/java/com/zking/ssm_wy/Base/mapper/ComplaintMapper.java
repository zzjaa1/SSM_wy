package com.zking.ssm_wy.Base.mapper;

import java.util.List;
import java.util.Map;

public interface ComplaintMapper {
    List<Map<String,Object>> queryComplaintPage(String cname);

    List<Map<String,Object>> queryComplaint2Page(String cname);

    List<Map<String,Object>> queryComplaint3Page(String cname);

    List<Map<String,Object>> queryComplaint4Page(String cname);

    List<Map<String,Object>> queryComplaint5Page(String cname);

    String delComplaint(int cid);
}
