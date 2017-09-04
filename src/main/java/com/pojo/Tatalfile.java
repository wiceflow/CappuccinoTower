package com.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Tatalfile implements Serializable {
    /**
     * 文件总表编号
     */
    private Integer totalfileId;

    /**
     * 文件夹编号
     */
    private Integer folderId;

    /**
     * 文件编号
     */
    private Integer fileId;

    private static final long serialVersionUID = 1L;

    public Integer getTotalfileId() {
        return totalfileId;
    }

    public void setTotalfileId(Integer totalfileId) {
        this.totalfileId = totalfileId;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
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
        Tatalfile other = (Tatalfile) that;
        return (this.getTotalfileId() == null ? other.getTotalfileId() == null : this.getTotalfileId().equals(other.getTotalfileId()))
            && (this.getFolderId() == null ? other.getFolderId() == null : this.getFolderId().equals(other.getFolderId()))
            && (this.getFileId() == null ? other.getFileId() == null : this.getFileId().equals(other.getFileId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTotalfileId() == null) ? 0 : getTotalfileId().hashCode());
        result = prime * result + ((getFolderId() == null) ? 0 : getFolderId().hashCode());
        result = prime * result + ((getFileId() == null) ? 0 : getFileId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", totalfileId=").append(totalfileId);
        sb.append(", folderId=").append(folderId);
        sb.append(", fileId=").append(fileId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}