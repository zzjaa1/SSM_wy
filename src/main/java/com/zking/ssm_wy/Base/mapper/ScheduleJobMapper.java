package com.zking.ssm_wy.Base.mapper;

import com.zking.ssm_wy.Base.model.ScheduleJob;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleJobMapper {
    int deleteByPrimaryKey(Long jobId);

    int insert(ScheduleJob record);

    int insertSelective(ScheduleJob record);

    ScheduleJob selectByPrimaryKey(Long jobId);

    int updateByPrimaryKeySelective(ScheduleJob record);

    int updateByPrimaryKey(ScheduleJob record);

    List<ScheduleJob> getAll();
}