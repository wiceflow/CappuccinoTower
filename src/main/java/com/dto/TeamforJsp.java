package com.dto;

/**
 * Created by WU on 2017/9/21.
 */
public class TeamforJsp {
    /**
     * 团队编号（主键）
     */
    private Integer tId;

    /**
     * 团队名称
     */
    private String tName;
    /**
     * 是否存在分组（0代表无分组，1代表有）默认0
     */
    private Integer isgroup;

    /**
     * 分组编号（主键）
     */
    private Integer gId;

    /**
     * 分组名字
     */
    private String gName;

    /**
     * 用户编号（主键）
     */
    private Integer uId;

    /**
     * 用户邮箱
     */
    private String uEmail;

    /**
     * 用户头像（可为空）
     */
    private String uPicture;

    /**
     * 用户名
     */
    private String uName;

    /**
     * 用户身份，默认为0（0为组员，1为超管，2为普通管理员，其他为游客）
     */
    private Integer type;

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }


    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer getIsgroup() {
        return isgroup;
    }

    public void setIsgroup(Integer isgroup) {
        this.isgroup = isgroup;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
