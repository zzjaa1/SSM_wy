package com.zking.ssm_wy.Base.service;

import java.util.List;
import java.util.Map;

public interface IOwnerService {
    List<Map<String,Object>> queryOwner(String name);
}
