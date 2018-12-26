package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.RealEstate;
import com.zking.ssm_wy.Base.service.IHousesService;
import com.zking.ssm_wy.Base.service.IRealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class RealEstateController {
    @Autowired
    private IRealEstateService iRealEstateService;

    @Autowired
    private IHousesService iHousesService;

    @RequestMapping("/addReall")
    @ResponseBody
    public String addReall(RealEstate realEstate){
        System.out.println("realEstate="+realEstate);
        iRealEstateService.addReal(realEstate);
        iHousesService.UpdateState(realEstate.getHnumber());
        return "成功";
    }


}
