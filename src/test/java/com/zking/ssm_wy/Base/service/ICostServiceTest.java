package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.service.imp.BaseTestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ICostServiceTest extends BaseTestCase {

    @Autowired
    private ICostService iCostService;

    @Before
    public void setUp() throws Exception{
        super.setUp();
    }


    @Test
    public void queryCost() {
        List<Map<String, Object>> maps = iCostService.queryCostPager("XQ4-B1-DY2-S101");
        for (Map<String, Object> map : maps) {
            System.out.print(map);
        }
    }
}