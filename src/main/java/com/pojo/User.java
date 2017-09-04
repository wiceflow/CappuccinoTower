package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class User implements Serializable {
    /**
     * 用户编号（主键）
     */
    private Integer uId;

    /**
     * 用户邮箱
     */
    private String uEmail;

    /**
     * 用户密码
     */
    private String uPassword;

    /**
     * 用户头像（可为空）
     */
    private String uPicture;

    /**
     * 用户名
     */
    private String uName;

    private static final long serialVersionUID = 1L;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuPicture() {
        return uPicture;
    }

    public void setuPicture(String uPicture) {
        this.uPicture = uPicture;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
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
        User other = (User) that;
        return (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getuEmail() == null ? other.getuEmail() == null : this.getuEmail().equals(other.getuEmail()))
            && (this.getuPassword() == null ? other.getuPassword() == null : this.getuPassword().equals(other.getuPassword()))
            && (this.getuPicture() == null ? other.getuPicture() == null : this.getuPicture().equals(other.getuPicture()))
            && (this.getuName() == null ? other.getuName() == null : this.getuName().equals(other.getuName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getuEmail() == null) ? 0 : getuEmail().hashCode());
        result = prime * result + ((getuPassword() == null) ? 0 : getuPassword().hashCode());
        result = prime * result + ((getuPicture() == null) ? 0 : getuPicture().hashCode());
        result = prime * result + ((getuName() == null) ? 0 : getuName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uId=").append(uId);
        sb.append(", uEmail=").append(uEmail);
        sb.append(", uPassword=").append(uPassword);
        sb.append(", uPicture=").append(uPicture);
        sb.append(", uName=").append(uName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}