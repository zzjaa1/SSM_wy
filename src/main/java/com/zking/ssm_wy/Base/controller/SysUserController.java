package com.zking.ssm_wy.Base.controller;

import com.zking.ssm_wy.Base.model.SysUser;
import com.zking.ssm_wy.Base.service.ISysPermissionService;
import com.zking.ssm_wy.Base.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private ISysPermissionService iSysPermissionService;

    @RequestMapping("/sysUseLogin")
    @ResponseBody
    public Map<String,Object> sysUseLogin(SysUser sysUser, HttpServletRequest request){
        System.out.println(sysUser);
        SysUser sysUser1 = iSysUserService.userLogin(sysUser);
        Map<String,Object> map =new HashMap<>();
        if (null==sysUser1){
            map.put("success",false);
            map.put("msg","用户名或密码错误！");
        }else {
            List<Map<String, Object>> maps = iSysPermissionService.queryPermissione2(sysUser1.getUserid());
            sysUser1.setSysPermissions(maps);
            request.getSession().setAttribute("User", sysUser1);
            map.put("success",true);
            map.put("msg","登录成功！");
        }
        return map;
    }

}
