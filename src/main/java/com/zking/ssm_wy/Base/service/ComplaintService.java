package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Complaint;
import com.zking.ssm_wy.Base.util.PageBean;

import java.util.List;
import java.util.Map;

public interface ComplaintService {
    List<Map<String,Object>> queryComplaintPage(String cname, PageBean pb);

    List<Map<String,Object>> queryComplaint2Page(String cname, PageBean pb);

    List<Map<String,Object>> queryComplaint3Page(String cname, PageBean pb);

    List<Map<String,Object>> queryComplaint4Page(String cname, PageBean pb);

    List<Map<String,Object>> queryComplaint5Page(String cname, PageBean pb);

    String delComplaint(int cid);

    String addComplaint(Complaint complaint);
}
