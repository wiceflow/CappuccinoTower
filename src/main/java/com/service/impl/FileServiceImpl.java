package com.service.impl;

import com.dao.FileMapper;
import com.dao.TotalfileMapper;
import com.pojo.File;
import com.pojo.FileExample;
import com.pojo.Project;
import com.pojo.Totalfile;
import com.service.FileService;
import com.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/8/30.
 * 文件的增删改查[File]
 */
@Service
@Transactional
public class FileServiceImpl implements FileService {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(FileServiceImpl.class);
    //注入文件
    @Autowired
    FileMapper fileMapper;

    //注入项目总表
    @Autowired
    ProjectService projectService;

    @Autowired
    //注入总表
    TotalfileMapper totalfileMapper;
    public File addFile(File file,int pId) {
        System.out.println("这是在servicedepid"+pId);
        Project project=new Project();
        int totalid;
        project.setpId(pId);
        //根据项目id查找项目中所有的数据，判断是否有文件总表
        List<Project> projectList = projectService.selectProject(project, 0);
        System.out.println("这是在service的project"+projectList);
        if(projectList.get(0).getfTotalid()==null||projectList.get(0).getfTotalid()==0){
            Totalfile totalfile=new Totalfile();
            totalfileMapper.insert(totalfile);
            totalid=totalfile.getTotalfileId();
            //将文件总表的id加入project中
            project=projectList.get(0);
            project.setfTotalid(totalid);
            //更新project
            projectService.updateProject(project);
        }else{
            totalid=projectList.get(0).getfTotalid();
        }
        System.out.println();
        String path = file.getFileUrl();
        if (path != null) {
            try {
                file.setTotalfileId(totalid);
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

    /**
     * 根据文件总表totalid对文件进行查询
     * @param totalid
     * @return
     */
    public List<File> QueryList(int totalid) {
        List<File> list = new ArrayList<File>();
        FileExample fileExample = new FileExample();
        fileExample.createCriteria().andTotalfileIdEqualTo(totalid);
        list = fileMapper.selectByExample(fileExample);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list;
    }

}
