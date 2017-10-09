package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Groupofteam implements Serializable {
    /**
     * 分组编号（主键）
     */
    private Integer gId;

    /**
     * 团队编号
     */
    private Integer tId;

    /**
     * 团队名称
     */
    private String gName;

    private static final long serialVersionUID = 1L;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
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
        Groupofteam other = (Groupofteam) that;
        return (this.getgId() == null ? other.getgId() == null : this.getgId().equals(other.getgId()))
            && (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.getgName() == null ? other.getgName() == null : this.getgName().equals(other.getgName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getgId() == null) ? 0 : getgId().hashCode());
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((getgName() == null) ? 0 : getgName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gId=").append(gId);
        sb.append(", tId=").append(tId);
        sb.append(", gName=").append(gName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}