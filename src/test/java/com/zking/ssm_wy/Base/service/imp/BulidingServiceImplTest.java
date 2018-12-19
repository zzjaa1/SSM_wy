package com.zking.ssm_wy.Base.service.imp;

import com.zking.ssm_wy.Base.service.IBulidingService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BulidingServiceImplTest extends BaseTestCase {

    @Autowired
    private IBulidingService iBulidingService;

    @Before
    public void setUp() throws Exception{
        super.setUp();
    }

    @Test
    public void queryBulid() {
        List<Map<String, Object>> xq4 =
                iBulidingService.queryBulid("XQ4");
        for (Map<String, Object> map : xq4) {

            System.out.println(map);
        }
    }

}