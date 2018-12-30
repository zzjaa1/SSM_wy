package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.ComplaintMapper;
import com.zking.ssm_wy.Base.mapper.RepairsMapper;
import com.zking.ssm_wy.Base.service.ComplaintService;
import com.zking.ssm_wy.Base.service.RepairsService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class RepairsserviceImpl implements RepairsService {
    @Autowired
    private RepairsMapper repairsMapper;
    @Override
    public List<Map<String, Object>> queryRepairsPage(String cname, PageBean pb) {
        return repairsMapper.queryRepairsPage(cname);
    }

    @Override
    public List<Map<String, Object>> queryRepairs2Page(String cname, PageBean pb) {
        return repairsMapper.queryRepairs2Page(cname);
    }

    @Override
    public List<Map<String, Object>> queryRepairs3Page(String cname, PageBean pb) {
        return repairsMapper.queryRepairs3Page(cname);
    }

    @Override
    public List<Map<String, Object>> queryRepairs4Page(String cname, PageBean pb) {
        return repairsMapper.queryRepairs4Page(cname);
    }

    @Override
    public List<Map<String, Object>> queryRepairs5Page(String cname, PageBean pb) {
        return repairsMapper.queryRepairs5Page(cname);
    }

    @Override
    public String delRepairs(int cid) {
        return repairsMapper.delRepairs(cid);
    }
}
