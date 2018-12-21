package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.XiaoQuMapper;
import com.zking.ssm_wy.Base.model.XiaoQu;
import com.zking.ssm_wy.Base.service.IXiaoQuService;
import com.zking.ssm_wy.Base.vo.XiaoQuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class XiaoQuServiceImpl implements IXiaoQuService {

    @Autowired
    private XiaoQuMapper  xiaoQuMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> querysf(XiaoQuVo xiaoQuVo) {
        return xiaoQuMapper.querysf(xiaoQuVo);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> queryxq(XiaoQu xiaoQur) {
        return xiaoQuMapper.queryxq(xiaoQur);
    }
}
