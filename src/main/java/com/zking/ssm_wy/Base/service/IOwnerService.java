package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.Owner;
import com.zking.ssm_wy.Base.util.PageBean;

import java.util.List;
import java.util.Map;

public interface IOwnerService {
    List<Map<String,Object>> queryOwner(String name);

    List<Map<String,Object>> queryowenPage(String o_name ,String h_number, PageBean pageBean);

}
