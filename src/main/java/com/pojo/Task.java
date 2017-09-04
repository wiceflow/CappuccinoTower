package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Task implements Serializable {
    /**
     * 任务编号（主键）
     */
    private Integer taskId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务创建时间
     */
    private Date taskCreatetime;

    /**
     * 任务完成时间
     */
    private Date taskFinishtime;

    /**
     * 任务创建人
     */
    private Integer taskUser;

    /**
     * 任务被指派者
     */
    private Integer taskAssigner;

    /**
     * 状态（0未开始，1正在执行，2完成）默认0
     */
    private Integer status;

    /**
     * 任务描述（可为空）
     */
    private String taskDescribe;

    private static final long serialVersionUID = 1L;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskCreatetime() {
        return taskCreatetime;
    }

    public void setTaskCreatetime(Date taskCreatetime) {
        this.taskCreatetime = taskCreatetime;
    }

    public Date getTaskFinishtime() {
        return taskFinishtime;
    }

    public void setTaskFinishtime(Date taskFinishtime) {
        this.taskFinishtime = taskFinishtime;
    }

    public Integer getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(Integer taskUser) {
        this.taskUser = taskUser;
    }

    public Integer getTaskAssigner() {
        return taskAssigner;
    }

    public void setTaskAssigner(Integer taskAssigner) {
        this.taskAssigner = taskAssigner;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTaskDescribe() {
        return taskDescribe;
    }

    public void setTaskDescribe(String taskDescribe) {
        this.taskDescribe = taskDescribe;
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
        Task other = (Task) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getTaskCreatetime() == null ? other.getTaskCreatetime() == null : this.getTaskCreatetime().equals(other.getTaskCreatetime()))
            && (this.getTaskFinishtime() == null ? other.getTaskFinishtime() == null : this.getTaskFinishtime().equals(other.getTaskFinishtime()))
            && (this.getTaskUser() == null ? other.getTaskUser() == null : this.getTaskUser().equals(other.getTaskUser()))
            && (this.getTaskAssigner() == null ? other.getTaskAssigner() == null : this.getTaskAssigner().equals(other.getTaskAssigner()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTaskDescribe() == null ? other.getTaskDescribe() == null : this.getTaskDescribe().equals(other.getTaskDescribe()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getTaskCreatetime() == null) ? 0 : getTaskCreatetime().hashCode());
        result = prime * result + ((getTaskFinishtime() == null) ? 0 : getTaskFinishtime().hashCode());
        result = prime * result + ((getTaskUser() == null) ? 0 : getTaskUser().hashCode());
        result = prime * result + ((getTaskAssigner() == null) ? 0 : getTaskAssigner().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTaskDescribe() == null) ? 0 : getTaskDescribe().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskId=").append(taskId);
        sb.append(", taskName=").append(taskName);
        sb.append(", taskCreatetime=").append(taskCreatetime);
        sb.append(", taskFinishtime=").append(taskFinishtime);
        sb.append(", taskUser=").append(taskUser);
        sb.append(", taskAssigner=").append(taskAssigner);
        sb.append(", status=").append(status);
        sb.append(", taskDescribe=").append(taskDescribe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}