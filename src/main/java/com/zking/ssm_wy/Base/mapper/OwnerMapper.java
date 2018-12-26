package com.zking.ssm_wy.Base.mapper;

import java.util.List;
import java.util.Map;

public interface OwnerMapper {
    List<Map<String,Object>> queryOwner(String oname);
}
