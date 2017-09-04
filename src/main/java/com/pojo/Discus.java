package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Discus implements Serializable {
    /**
     * 讨论编号（主键）
     */
    private Integer discusId;

    /**
     * 讨论话题
     */
    private String dTopic;

    /**
     * 讨论内容
     */
    private String dContent;

    private static final long serialVersionUID = 1L;

    public Integer getDiscusId() {
        return discusId;
    }

    public void setDiscusId(Integer discusId) {
        this.discusId = discusId;
    }

    public String getdTopic() {
        return dTopic;
    }

    public void setdTopic(String dTopic) {
        this.dTopic = dTopic;
    }

    public String getdContent() {
        return dContent;
    }

    public void setdContent(String dContent) {
        this.dContent = dContent;
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
        Discus other = (Discus) that;
        return (this.getDiscusId() == null ? other.getDiscusId() == null : this.getDiscusId().equals(other.getDiscusId()))
            && (this.getdTopic() == null ? other.getdTopic() == null : this.getdTopic().equals(other.getdTopic()))
            && (this.getdContent() == null ? other.getdContent() == null : this.getdContent().equals(other.getdContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiscusId() == null) ? 0 : getDiscusId().hashCode());
        result = prime * result + ((getdTopic() == null) ? 0 : getdTopic().hashCode());
        result = prime * result + ((getdContent() == null) ? 0 : getdContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", discusId=").append(discusId);
        sb.append(", dTopic=").append(dTopic);
        sb.append(", dContent=").append(dContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}