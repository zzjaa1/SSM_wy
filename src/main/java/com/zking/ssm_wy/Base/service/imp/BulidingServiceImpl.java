package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.BulidingMapper;
import com.zking.ssm_wy.Base.model.Buliding;
import com.zking.ssm_wy.Base.service.IBulidingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class BulidingServiceImpl implements IBulidingService {

    @Autowired
    private BulidingMapper bulidingMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> queryBulid(String x_number) {
        return bulidingMapper.queryBulid(x_number);
    }

    @Transactional
    @Override
    public int insertSelective(Buliding record) {
        return bulidingMapper.insertSelective(record);
    }

    @Override
    public String QueryId() {
        return bulidingMapper.QueryId();
    }

    @Override
    public int updateunitname(Buliding buliding) {
        return bulidingMapper.updateunitname(buliding);
    }

    @Override
    public int update(Buliding buliding) {
        return bulidingMapper.update(buliding);
    }
}
