package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Userandteam implements Serializable {
    /**
     * 编号（自增，主键）
     */
    private Integer utId;

    /**
     * 团队编号ID
     */
    private Integer tId;

    /**
     * 用户编号ID
     */
    private Integer uId;

    /**
     * 用户身份，默认为0（0为组员，1为超管，2为普通管理员，其他为游客）
     */
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getUtId() {
        return utId;
    }

    public void setUtId(Integer utId) {
        this.utId = utId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        Userandteam other = (Userandteam) that;
        return (this.getUtId() == null ? other.getUtId() == null : this.getUtId().equals(other.getUtId()))
            && (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUtId() == null) ? 0 : getUtId().hashCode());
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", utId=").append(utId);
        sb.append(", tId=").append(tId);
        sb.append(", uId=").append(uId);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}