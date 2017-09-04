package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Team implements Serializable {
    /**
     * 团队编号（主键）
     */
    private Integer tId;

    /**
     * 团队名称
     */
    private String tName;

    /**
     * 是否存在分组（0代表无分组，1代表有）默认0
     */
    private Integer isgroup;

    private static final long serialVersionUID = 1L;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer getIsgroup() {
        return isgroup;
    }

    public void setIsgroup(Integer isgroup) {
        this.isgroup = isgroup;
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
        Team other = (Team) that;
        return (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.gettName() == null ? other.gettName() == null : this.gettName().equals(other.gettName()))
            && (this.getIsgroup() == null ? other.getIsgroup() == null : this.getIsgroup().equals(other.getIsgroup()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((gettName() == null) ? 0 : gettName().hashCode());
        result = prime * result + ((getIsgroup() == null) ? 0 : getIsgroup().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tId=").append(tId);
        sb.append(", tName=").append(tName);
        sb.append(", isgroup=").append(isgroup);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}