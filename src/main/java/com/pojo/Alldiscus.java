package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Alldiscus implements Serializable {
    /**
     * 讨论总表编号
     */
    private Integer discusallId;

    /**
     * 讨论表编号
     */
    private Integer discusId;

    private static final long serialVersionUID = 1L;

    public Integer getDiscusallId() {
        return discusallId;
    }

    public void setDiscusallId(Integer discusallId) {
        this.discusallId = discusallId;
    }

    public Integer getDiscusId() {
        return discusId;
    }

    public void setDiscusId(Integer discusId) {
        this.discusId = discusId;
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
        Alldiscus other = (Alldiscus) that;
        return (this.getDiscusallId() == null ? other.getDiscusallId() == null : this.getDiscusallId().equals(other.getDiscusallId()))
            && (this.getDiscusId() == null ? other.getDiscusId() == null : this.getDiscusId().equals(other.getDiscusId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiscusallId() == null) ? 0 : getDiscusallId().hashCode());
        result = prime * result + ((getDiscusId() == null) ? 0 : getDiscusId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", discusallId=").append(discusallId);
        sb.append(", discusId=").append(discusId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}