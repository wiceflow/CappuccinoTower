package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Userandgroup implements Serializable {
    /**
     * 编号（主键）
     */
    private Integer ugId;

    /**
     * 用户编号
     */
    private Integer uId;

    /**
     * 分组编号
     */
    private Integer gId;

    private static final long serialVersionUID = 1L;

    public Integer getUgId() {
        return ugId;
    }

    public void setUgId(Integer ugId) {
        this.ugId = ugId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
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
        Userandgroup other = (Userandgroup) that;
        return (this.getUgId() == null ? other.getUgId() == null : this.getUgId().equals(other.getUgId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getgId() == null ? other.getgId() == null : this.getgId().equals(other.getgId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUgId() == null) ? 0 : getUgId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getgId() == null) ? 0 : getgId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ugId=").append(ugId);
        sb.append(", uId=").append(uId);
        sb.append(", gId=").append(gId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}