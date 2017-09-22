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

    private Integer cId;

    private Integer discusallId;

    private Integer uId;

    private String uName;

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

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getDiscusallId() {
        return discusallId;
    }

    public void setDiscusallId(Integer discusallId) {
        this.discusallId = discusallId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
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
            && (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getDiscusallId() == null ? other.getDiscusallId() == null : this.getDiscusallId().equals(other.getDiscusallId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getuName() == null ? other.getuName() == null : this.getuName().equals(other.getuName()))
            && (this.getdContent() == null ? other.getdContent() == null : this.getdContent().equals(other.getdContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiscusId() == null) ? 0 : getDiscusId().hashCode());
        result = prime * result + ((getdTopic() == null) ? 0 : getdTopic().hashCode());
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        result = prime * result + ((getDiscusallId() == null) ? 0 : getDiscusallId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getuName() == null) ? 0 : getuName().hashCode());
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
        sb.append(", cId=").append(cId);
        sb.append(", discusallId=").append(discusallId);
        sb.append(", uId=").append(uId);
        sb.append(", uName=").append(uName);
        sb.append(", dContent=").append(dContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}