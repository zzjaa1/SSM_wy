package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OwnerMapper {
    int UpdateOwen(Owner owner);
    List<Map<String,Object>> queryOwner(String oname);

    List<Map<String,Object>> queryowenPage(@Param("o_name") String o_name , @Param("h_number") String h_number);

    int deleteOwen(String O_number);

}
