package com.service.impl;

import com.dao.TotalfileMapper;
import com.dto.TotalfileforJsp;
import com.pojo.File;
import com.pojo.Folder;
import com.pojo.Project;
import com.pojo.Totalfile;
import com.service.FileService;
import com.service.FolderService;
import com.service.ProjectService;
import com.service.TatalfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/9/20.
 */
@Service
@Transactional
public class TotalfileServiceImpl implements TatalfileService {
    @Autowired
    ProjectService projectService;
    @Autowired
    TotalfileMapper totalfileMapper;
    @Autowired
    FileService fileService;
    @Autowired
    FolderService folderService;


    public int addTatalfile(Totalfile tatalfile) {
        return 0;
    }

    public int deleteTatalfile(int totalfileId) {
        return 0;
    }

    public int updateTatalfile(Totalfile tatalfile) {
        return 0;
    }

    public List<Totalfile> selectTatalfile(Totalfile tatalfile, int i) {
        return null;
    }

    /**
     * 根据项目id进行查找
     * @param pId
     * @return
     */
    public List<TotalfileforJsp> QueryByPid(int pId) {
        List<TotalfileforJsp> totalfileforJspList=new ArrayList<TotalfileforJsp>();
        Project project=new Project();
        project.setpId(pId);
        //根据项目id进行查找
        List<Project> projectList = projectService.selectProject(project, 0);
        if (projectList.get(0).getfTotalid()!=null){
            List<File> fileList = fileService.QueryList(projectList.get(0).getfTotalid());
            List<Folder> folderList = folderService.QueryList(projectList.get(0).getfTotalid());
            if(fileList!=null&&folderList!=null){
                for(int i=0;i<fileList.size();i++){
                    TotalfileforJsp totalfileforJsp=new TotalfileforJsp();
                    //向DTO中添加数据
                    totalfileforJsp.setTotalfileId(projectList.get(0).getfTotalid());
                    totalfileforJsp.setFileId(fileList.get(i).getFileId());
                    totalfileforJsp.setFileName(fileList.get(i).getFileName());
                    totalfileforJsp.setFileUrl(fileList.get(i).getFileUrl());
                    //判断文件是否有文件夹的父类
                    if (fileList.get(i).getFolderId()!=null){
                        //2为有文件夹父类的文件
                        totalfileforJsp.setType(2);
                    }else {
                        //0为文件
                        totalfileforJsp.setType(0);
                    }

                    totalfileforJspList.add(totalfileforJsp);
                }
                for (int j=0;j<folderList.size();j++){
                    TotalfileforJsp totalfileforJsp=new TotalfileforJsp();
                    //向DTO中添加数据
                    totalfileforJsp.setTotalfileId(projectList.get(0).getfTotalid());
                    totalfileforJsp.setFolderId(folderList.get(j).getFolderId());
                    totalfileforJsp.setFolderName(folderList.get(j).getFolderName());
                    System.out.println(totalfileforJsp.getFolderName()+"这是文件夹的名字----》");
                    //1为文件夹
                    totalfileforJsp.setType(1);
                    totalfileforJspList.add(totalfileforJsp);
                }
                return totalfileforJspList;
            }
        }
        return null;
    }

}
