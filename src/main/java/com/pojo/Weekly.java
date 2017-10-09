package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Weekly implements Serializable {
    /**
     * 周报编号
     */
    private Integer weeklyId;

    /**
     * 周报创建时间
     */
    private Date wTime;

    /**
     * 周报发起人
     */
    private Integer uId;

    /**
     * 工作总结
     */
    private String wSummary;

    /**
     * 工作挑战或困难
     */
    private String wChallenge;

    /**
     * 工作目标
     */
    private String wTarget;

    /**
     * 采取的措施
     */
    private String wMethod;

    /**
     * 团队id
     */
    private Integer tId;

    /**
     * 项目id
     */
    private Integer pId;

    private static final long serialVersionUID = 1L;

    public Integer getWeeklyId() {
        return weeklyId;
    }

    public void setWeeklyId(Integer weeklyId) {
        this.weeklyId = weeklyId;
    }

    public Date getwTime() {
        return wTime;
    }

    public void setwTime(Date wTime) {
        this.wTime = wTime;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getwSummary() {
        return wSummary;
    }

    public void setwSummary(String wSummary) {
        this.wSummary = wSummary;
    }

    public String getwChallenge() {
        return wChallenge;
    }

    public void setwChallenge(String wChallenge) {
        this.wChallenge = wChallenge;
    }

    public String getwTarget() {
        return wTarget;
    }

    public void setwTarget(String wTarget) {
        this.wTarget = wTarget;
    }

    public String getwMethod() {
        return wMethod;
    }

    public void setwMethod(String wMethod) {
        this.wMethod = wMethod;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
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
        Weekly other = (Weekly) that;
        return (this.getWeeklyId() == null ? other.getWeeklyId() == null : this.getWeeklyId().equals(other.getWeeklyId()))
            && (this.getwTime() == null ? other.getwTime() == null : this.getwTime().equals(other.getwTime()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getwSummary() == null ? other.getwSummary() == null : this.getwSummary().equals(other.getwSummary()))
            && (this.getwChallenge() == null ? other.getwChallenge() == null : this.getwChallenge().equals(other.getwChallenge()))
            && (this.getwTarget() == null ? other.getwTarget() == null : this.getwTarget().equals(other.getwTarget()))
            && (this.getwMethod() == null ? other.getwMethod() == null : this.getwMethod().equals(other.getwMethod()))
            && (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWeeklyId() == null) ? 0 : getWeeklyId().hashCode());
        result = prime * result + ((getwTime() == null) ? 0 : getwTime().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getwSummary() == null) ? 0 : getwSummary().hashCode());
        result = prime * result + ((getwChallenge() == null) ? 0 : getwChallenge().hashCode());
        result = prime * result + ((getwTarget() == null) ? 0 : getwTarget().hashCode());
        result = prime * result + ((getwMethod() == null) ? 0 : getwMethod().hashCode());
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", weeklyId=").append(weeklyId);
        sb.append(", wTime=").append(wTime);
        sb.append(", uId=").append(uId);
        sb.append(", wSummary=").append(wSummary);
        sb.append(", wChallenge=").append(wChallenge);
        sb.append(", wTarget=").append(wTarget);
        sb.append(", wMethod=").append(wMethod);
        sb.append(", tId=").append(tId);
        sb.append(", pId=").append(pId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}