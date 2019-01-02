package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.ComplaintMapper;
import com.zking.ssm_wy.Base.model.Complaint;
import com.zking.ssm_wy.Base.service.ComplaintService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Transactional
@Service
public class ComplaintserviceImpl implements ComplaintService{
    @Autowired
    private ComplaintMapper complaintMapper;
    @Override
    public List<Map<String, Object>> queryComplaintPage(String cname, PageBean pb) {
        return complaintMapper.queryComplaintPage(cname);
    }

    @Override
    public List<Map<String, Object>> queryComplaint2Page(String cname, PageBean pb) {
        return complaintMapper.queryComplaint2Page(cname);
    }

    @Override
    public List<Map<String, Object>> queryComplaint3Page(String cname, PageBean pb) {
        return complaintMapper.queryComplaint3Page(cname);
    }

    @Override
    public List<Map<String, Object>> queryComplaint4Page(String cname, PageBean pb) {
        return complaintMapper.queryComplaint4Page(cname);
    }

    @Override
    public List<Map<String, Object>> queryComplaint5Page(String cname, PageBean pb) {
        return complaintMapper.queryComplaint5Page(cname);
    }

    @Override
    public String delComplaint(int cid) {
        return complaintMapper.delComplaint(cid);
    }

    @Override
    public String addComplaint(Complaint complaint) {
        return complaintMapper.addComplaint(complaint);
    }
}
