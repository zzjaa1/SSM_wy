package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.Lease;
import com.zking.ssm_wy.Base.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LeaseController {
    @Autowired
    private LeaseService leaseService;
    @RequestMapping("/addLease")
    @ResponseBody
    public String addLease(Lease lease){
        leaseService.addLease(lease);
        return null;
    }
}
