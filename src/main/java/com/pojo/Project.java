package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Project implements Serializable {
    /**
     * 项目编号（主键）
     */
    private Integer pId;

    /**
     * 项目名称
     */
    private String pName;

    /**
     * 是否敏感信息（0为不敏感，1为敏感）默认0
     */
    private Integer pSensitive;

    /**
     * 是否公开（0为公开，1为公开）默认不公开
     */
    private Integer ispublic;

    /**
     * 团队编号
     */
    private Integer tId;

    /**
     * 讨论总表编号
     */
    private Integer discusallid;

    /**
     * 文件总表编号
     */
    private Integer fTotalid;

    /**
     * 项目描述（可为空）
     */
    private String pDescribe;

    private static final long serialVersionUID = 1L;

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

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getDiscusallid() {
        return discusallid;
    }

    public void setDiscusallid(Integer discusallid) {
        this.discusallid = discusallid;
    }

    public Integer getfTotalid() {
        return fTotalid;
    }

    public void setfTotalid(Integer fTotalid) {
        this.fTotalid = fTotalid;
    }

    public String getpDescribe() {
        return pDescribe;
    }

    public void setpDescribe(String pDescribe) {
        this.pDescribe = pDescribe;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Project other = (Project) that;
        return (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getpName() == null ? other.getpName() == null : this.getpName().equals(other.getpName()))
            && (this.getpSensitive() == null ? other.getpSensitive() == null : this.getpSensitive().equals(other.getpSensitive()))
            && (this.getIspublic() == null ? other.getIspublic() == null : this.getIspublic().equals(other.getIspublic()))
            && (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.getDiscusallid() == null ? other.getDiscusallid() == null : this.getDiscusallid().equals(other.getDiscusallid()))
            && (this.getfTotalid() == null ? other.getfTotalid() == null : this.getfTotalid().equals(other.getfTotalid()))
            && (this.getpDescribe() == null ? other.getpDescribe() == null : this.getpDescribe().equals(other.getpDescribe()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getpName() == null) ? 0 : getpName().hashCode());
        result = prime * result + ((getpSensitive() == null) ? 0 : getpSensitive().hashCode());
        result = prime * result + ((getIspublic() == null) ? 0 : getIspublic().hashCode());
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((getDiscusallid() == null) ? 0 : getDiscusallid().hashCode());
        result = prime * result + ((getfTotalid() == null) ? 0 : getfTotalid().hashCode());
        result = prime * result + ((getpDescribe() == null) ? 0 : getpDescribe().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", pName=").append(pName);
        sb.append(", pSensitive=").append(pSensitive);
        sb.append(", ispublic=").append(ispublic);
        sb.append(", tId=").append(tId);
        sb.append(", discusallid=").append(discusallid);
        sb.append(", fTotalid=").append(fTotalid);
        sb.append(", pDescribe=").append(pDescribe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}