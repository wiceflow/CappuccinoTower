package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Totalfile implements Serializable {
    /**
     * 文件总表编号
     */
    private Integer totalfileId;

    private static final long serialVersionUID = 1L;

    public Integer getTotalfileId() {
        return totalfileId;
    }

    public void setTotalfileId(Integer totalfileId) {
        this.totalfileId = totalfileId;
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
        Totalfile other = (Totalfile) that;
        return (this.getTotalfileId() == null ? other.getTotalfileId() == null : this.getTotalfileId().equals(other.getTotalfileId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTotalfileId() == null) ? 0 : getTotalfileId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", totalfileId=").append(totalfileId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}