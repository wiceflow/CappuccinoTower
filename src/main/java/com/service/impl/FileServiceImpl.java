package com.service.impl;

import com.dao.FileMapper;
import com.pojo.File;
import com.pojo.FileExample;
import com.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/8/30.
 * 文件的增删改查[File]
 */
@Service
public class FileServiceImpl implements FileService {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(FileServiceImpl.class);
    @Autowired
    FileMapper fileMapper;

    public File addFile(File file) {
        String path = file.getFileUrl();
        if (path != null) {
            try {
                fileMapper.insert(file);
            } catch (Exception e) {
                _LOG.error("插入文件信息错误！");
                return null;
            }
        }
        return file;
    }

    public void deleteFile(int fileId) {
        if (fileId >= 0) {
            try {
                fileMapper.deleteByPrimaryKey(fileId);
            } catch (Exception e) {
                _LOG.error("删除一条文件数据失败！");
            }
        }
    }

    public int updateFile(File file) {
        return 0;
    }

    /**
     * 查询文件
     *
     * @param file   文件实体类
     * @param fileId 根据文件ID进行查找
     * @return
     */
    public List<File> selectFile(String file, int fileId) {
        List<File> fileList = new ArrayList<File>();
        File file1 = null;
        // 根据文件ID进行查询
        file1 = fileMapper.selectByPrimaryKey(fileId);
        if (file1 != null) {
            fileList.add(file1);
        }
        // 若查询为空则返回null
        if (fileList == null || fileList.size() == 0) {
            return null;
        }
        // 否则返回这个list
        return fileList;
    }

    public List<File> QueryList() {
        List<File> list = new ArrayList<File>();
        FileExample fileExample = new FileExample();
        // 过滤重复
        // fileExample.setDistinct(true);
        list = fileMapper.selectByExample(fileExample);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list;
    }

}
