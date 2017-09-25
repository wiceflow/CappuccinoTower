package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Taskinfo implements Serializable {
    /**
     * 任务清单编号
     */
    private Integer taskinfoId;

    /**
     * 任务清单名称
     */
    private String taskinfoName;

    /**
     * 任务清单创建者
     */
    private Integer taskinfoUser;

    /**
     * 项目编号
     */
    private Integer pId;

    /**
     * 任务清单描述
     */
    private String takinfoDescribe;

    private static final long serialVersionUID = 1L;

    public Integer getTaskinfoId() {
        return taskinfoId;
    }

    public void setTaskinfoId(Integer taskinfoId) {
        this.taskinfoId = taskinfoId;
    }

    public String getTaskinfoName() {
        return taskinfoName;
    }

    public void setTaskinfoName(String taskinfoName) {
        this.taskinfoName = taskinfoName;
    }

    public Integer getTaskinfoUser() {
        return taskinfoUser;
    }

    public void setTaskinfoUser(Integer taskinfoUser) {
        this.taskinfoUser = taskinfoUser;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getTakinfoDescribe() {
        return takinfoDescribe;
    }

    public void setTakinfoDescribe(String takinfoDescribe) {
        this.takinfoDescribe = takinfoDescribe;
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
        Taskinfo other = (Taskinfo) that;
        return (this.getTaskinfoId() == null ? other.getTaskinfoId() == null : this.getTaskinfoId().equals(other.getTaskinfoId()))
            && (this.getTaskinfoName() == null ? other.getTaskinfoName() == null : this.getTaskinfoName().equals(other.getTaskinfoName()))
            && (this.getTaskinfoUser() == null ? other.getTaskinfoUser() == null : this.getTaskinfoUser().equals(other.getTaskinfoUser()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getTakinfoDescribe() == null ? other.getTakinfoDescribe() == null : this.getTakinfoDescribe().equals(other.getTakinfoDescribe()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskinfoId() == null) ? 0 : getTaskinfoId().hashCode());
        result = prime * result + ((getTaskinfoName() == null) ? 0 : getTaskinfoName().hashCode());
        result = prime * result + ((getTaskinfoUser() == null) ? 0 : getTaskinfoUser().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getTakinfoDescribe() == null) ? 0 : getTakinfoDescribe().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskinfoId=").append(taskinfoId);
        sb.append(", taskinfoName=").append(taskinfoName);
        sb.append(", taskinfoUser=").append(taskinfoUser);
        sb.append(", pId=").append(pId);
        sb.append(", takinfoDescribe=").append(takinfoDescribe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}