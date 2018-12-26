package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.CostNameMapper;
import com.zking.ssm_wy.Base.model.CostName;
import com.zking.ssm_wy.Base.service.IcostnameService;
import com.zking.ssm_wy.Base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Transactional
@Service
public class costnameServiceImpl implements IcostnameService {

    @Autowired
    private CostNameMapper costnameMapper;

    @Override
    public List<Map<String, Object>> queryCostNamePage(CostName costn, PageBean pb) {
        return costnameMapper.queryCostNamePage(costn);
    }

    @Override
    public int updateByPrimaryKeySelective(CostName record) {
        return costnameMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer cnId) {
        return costnameMapper.deleteByPrimaryKey(cnId);
    }

    @Override
    public int insert(CostName record) {
        return costnameMapper.insert(record);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Map<String,Object>> queryName() {
        return costnameMapper.queryName();
    }


}
