package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.basDictMapper;
import com.zking.ssm_wy.Base.model.basDict;
import com.zking.ssm_wy.Base.service.IbasDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Transactional
@Service
public class basDictServiceImpl implements IbasDictService {

    @Autowired
    private  basDictMapper basdictMapper;
    @Override
    public List<Map<String, Object>> querybasDict(basDict basdict) {
        return basdictMapper.querybasDict(basdict);
    }
}
