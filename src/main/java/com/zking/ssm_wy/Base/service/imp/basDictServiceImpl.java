package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.mapper.basDictMapper;
import com.zking.ssm_wy.Base.model.basDict;
import com.zking.ssm_wy.Base.service.IbasDictService;
import com.zking.ssm_wy.Base.util.PageBean;
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

    @Override
    public List<Map<String, Object>> querybasDictPage(basDict basdict, PageBean pb) {
        return basdictMapper.querybasDictPage(basdict);
    }

    @Override
    public int deleteByPrimaryKey(Long dictId) {
        return basdictMapper.deleteByPrimaryKey(dictId);
    }

    @Override
    public int insertSelective(basDict record) {
        return basdictMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(basDict record) {
        return basdictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void updpl(List<Map<String, Object>> list) {
         basdictMapper.updpl(list);
    }

    @Override
    public void delpl(List<Map<String, Object>> list) {
         basdictMapper.delpl(list);
    }
}
