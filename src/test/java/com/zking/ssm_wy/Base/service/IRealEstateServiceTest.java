package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.service.imp.BaseTestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IRealEstateServiceTest extends BaseTestCase {

    @Autowired
    private IRealEstateService iRealEstateService;

    @Before
    public void setUp() throws Exception{
    }

    @Test
    public void queryxsetj() {
        List<Map<String, Object>> queryxsetj =
                iRealEstateService.queryxsetj("2018");
        for (Map<String, Object> map : queryxsetj) {
            System.out.println(map);
        }
    }

    @Test
    public void queryxsetj2() {
        List<Map<String, Object>> xq4 = iRealEstateService.queryxsetj2("2018", "XQ4", "12");
        for (Map<String, Object> map : xq4) {
            System.out.println(map);
        }
    }
}