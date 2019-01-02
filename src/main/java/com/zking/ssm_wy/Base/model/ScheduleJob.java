package com.zking.ssm_wy.Base.model;

import java.io.Serializable;
import java.util.Date;

public class ScheduleJob implements Serializable {
    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";
    private Long jobId;

    private Date createTime;

    private Date updateTime;

    private String jobName;

    private String jobGroup;

    private String jobStatus;

    private String cronExpression;

    private String description;

    private String beanClass;

    private String isConcurrent;

    private String springId;

    private String methodName;

    public ScheduleJob(Long jobId, Date createTime, Date updateTime, String jobName, String jobGroup, String jobStatus, String cronExpression, String description, String beanClass, String isConcurrent, String springId, String methodName) {
        this.jobId = jobId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.jobStatus = jobStatus;
        this.cronExpression = cronExpression;
        this.description = description;
        this.beanClass = beanClass;
        this.isConcurrent = isConcurrent;
        this.springId = springId;
        this.methodName = methodName;
    }

    public ScheduleJob() {
        super();
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    public String getIsConcurrent() {
        return isConcurrent;
    }

    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public String getSpringId() {
        return springId;
    }

    public void setSpringId(String springId) {
        this.springId = springId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return "ScheduleJob{" +
                "jobId=" + jobId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", jobStatus='" + jobStatus + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", description='" + description + '\'' +
                ", beanClass='" + beanClass + '\'' +
                ", isConcurrent='" + isConcurrent + '\'' +
                ", springId='" + springId + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}