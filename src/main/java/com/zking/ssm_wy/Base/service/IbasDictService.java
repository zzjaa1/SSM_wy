package com.zking.ssm_wy.Base.service;

import com.zking.ssm_wy.Base.model.basDict;

import java.util.List;
import java.util.Map;

public interface IbasDictService {

    List<Map<String,Object>> querybasDict(basDict basdict);
}