package com.dto;

/**
 * Created by WU on 2017/9/20.
 */
public class TotalfileforJsp {
    /**
     * 文件总表编号
     */
    private Integer totalfileId;
    /**
     * 文件编号
     */
    private Integer fileId;

    /**
     * 上传路径
     */
    private String fileUrl;

    /**
     * 上传文件的名字
     */
    private String fileName;
    /**
     * 文件夹编号
     */
    private Integer folderId;
    /**
     * 文件夹名称
     */
    private String folderName;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * 用来判断是否是文件夹或者是文件，0为文件，1为文件夹

     */
    private int type;

    public Integer getTotalfileId() {
        return totalfileId;
    }

    public void setTotalfileId(Integer totalfileId) {
        this.totalfileId = totalfileId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}
