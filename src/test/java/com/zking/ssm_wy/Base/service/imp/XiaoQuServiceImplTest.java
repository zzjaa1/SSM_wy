package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.service.IXiaoQuService;
import com.zking.ssm_wy.Base.vo.XiaoQuVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class XiaoQuServiceImplTest extends BaseTestCase {

    @Autowired
    private IXiaoQuService iXiaoQuService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void querysf() {
        XiaoQuVo xiaoQuVo =new XiaoQuVo();
        xiaoQuVo.setNumber("O_phone");
        xiaoQuVo.setGjname("137");
        List<Map<String, Object>> querysf = iXiaoQuService.querysf(xiaoQuVo);
        for (Map<String, Object> map : querysf) {
            System.out.println(map);

        }

    }
}