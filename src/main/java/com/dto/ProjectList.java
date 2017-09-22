package com.dto;

/**
 * Created by WU on 2017/9/15.
 */
public class ProjectList {
    //项目编号（主键）
    private Integer pId;
    //项目名称
    private String pName;
    //是否敏感信息（0为不敏感，1为敏感）默认0
    private Integer pSensitive;
    //是否公开（0为公开，1为公开）默认不公开
    private Integer ispublic;
    //项目描述（可为空）
    private String pDescribe;

    public String getpDescribe() {
        return pDescribe;
    }

    public void setpDescribe(String pDescribe) {
        this.pDescribe = pDescribe;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getpSensitive() {
        return pSensitive;
    }

    public void setpSensitive(Integer pSensitive) {
        this.pSensitive = pSensitive;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }
}
