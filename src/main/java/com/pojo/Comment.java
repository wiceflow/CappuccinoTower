package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Comment implements Serializable {
    /**
     * 评论编号
     */
    private Integer cId;

    /**
     * 评论内容
     */
    private String cContent;

    /**
     * 发起评论者
     */
    private Integer uId;

    /**
     * 任务编号
     */
    private Integer taskId;

    /**
     * 评论时间
     */
    private Date cTime;

    /**
     * 发起评论者
     */
    private String uName;

    /**
     * 被评论者
     */
    private Integer buId;

    /**
     * 被评论名字
     */
    private String buUsername;

    /**
     * 被评论编号
     */
    private Integer bcId;

    private static final long serialVersionUID = 1L;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getBuId() {
        return buId;
    }

    public void setBuId(Integer buId) {
        this.buId = buId;
    }

    public String getBuUsername() {
        return buUsername;
    }

    public void setBuUsername(String buUsername) {
        this.buUsername = buUsername;
    }

    public Integer getBcId() {
        return bcId;
    }

    public void setBcId(Integer bcId) {
        this.bcId = bcId;
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
        Comment other = (Comment) that;
        return (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getcContent() == null ? other.getcContent() == null : this.getcContent().equals(other.getcContent()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getcTime() == null ? other.getcTime() == null : this.getcTime().equals(other.getcTime()))
            && (this.getuName() == null ? other.getuName() == null : this.getuName().equals(other.getuName()))
            && (this.getBuId() == null ? other.getBuId() == null : this.getBuId().equals(other.getBuId()))
            && (this.getBuUsername() == null ? other.getBuUsername() == null : this.getBuUsername().equals(other.getBuUsername()))
            && (this.getBcId() == null ? other.getBcId() == null : this.getBcId().equals(other.getBcId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        result = prime * result + ((getcContent() == null) ? 0 : getcContent().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getcTime() == null) ? 0 : getcTime().hashCode());
        result = prime * result + ((getuName() == null) ? 0 : getuName().hashCode());
        result = prime * result + ((getBuId() == null) ? 0 : getBuId().hashCode());
        result = prime * result + ((getBuUsername() == null) ? 0 : getBuUsername().hashCode());
        result = prime * result + ((getBcId() == null) ? 0 : getBcId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", cContent=").append(cContent);
        sb.append(", uId=").append(uId);
        sb.append(", taskId=").append(taskId);
        sb.append(", cTime=").append(cTime);
        sb.append(", uName=").append(uName);
        sb.append(", buId=").append(buId);
        sb.append(", buUsername=").append(buUsername);
        sb.append(", bcId=").append(bcId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}