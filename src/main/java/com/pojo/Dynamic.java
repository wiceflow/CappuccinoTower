package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Dynamic implements Serializable {
    /**
     * 动态编号
     */
    private Integer dynamicId;

    /**
     * 动态创建时间
     */
    private Date dTime;

    /**
     * 项目编号
     */
    private Integer pId;

    /**
     * 操作
     */
    private String action;

    /**
     * 用户编号
     */
    private Integer uId;

    /**
     * 被操作对象
     */
    private Integer beOperated;

    /**
     * 被操作表
     */
    private String beTable;

    private static final long serialVersionUID = 1L;

    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Date getdTime() {
        return dTime;
    }

    public void setdTime(Date dTime) {
        this.dTime = dTime;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getBeOperated() {
        return beOperated;
    }

    public void setBeOperated(Integer beOperated) {
        this.beOperated = beOperated;
    }

    public String getBeTable() {
        return beTable;
    }

    public void setBeTable(String beTable) {
        this.beTable = beTable;
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
        Dynamic other = (Dynamic) that;
        return (this.getDynamicId() == null ? other.getDynamicId() == null : this.getDynamicId().equals(other.getDynamicId()))
            && (this.getdTime() == null ? other.getdTime() == null : this.getdTime().equals(other.getdTime()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getAction() == null ? other.getAction() == null : this.getAction().equals(other.getAction()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getBeOperated() == null ? other.getBeOperated() == null : this.getBeOperated().equals(other.getBeOperated()))
            && (this.getBeTable() == null ? other.getBeTable() == null : this.getBeTable().equals(other.getBeTable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDynamicId() == null) ? 0 : getDynamicId().hashCode());
        result = prime * result + ((getdTime() == null) ? 0 : getdTime().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getBeOperated() == null) ? 0 : getBeOperated().hashCode());
        result = prime * result + ((getBeTable() == null) ? 0 : getBeTable().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dynamicId=").append(dynamicId);
        sb.append(", dTime=").append(dTime);
        sb.append(", pId=").append(pId);
        sb.append(", action=").append(action);
        sb.append(", uId=").append(uId);
        sb.append(", beOperated=").append(beOperated);
        sb.append(", beTable=").append(beTable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}