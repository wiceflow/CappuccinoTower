package com.service.impl;

import com.dao.FolderMapper;
import com.dao.TotalfileMapper;
import com.pojo.Folder;
import com.pojo.FolderExample;
import com.pojo.Project;
import com.pojo.Totalfile;
import com.service.FolderService;
import com.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/9/6.
 * 文件夹的增删改查[Folder]
 */
@Service
public class FolderServiceImpl implements FolderService{
    @Autowired
    FolderMapper folderMapper;
    @Autowired
    ProjectService projectService;
    @Autowired
    TotalfileMapper totalfileMapper;
    public int addFolder(Folder folder,int pId) {
        Project project=new Project();
        project.setpId(pId);
        //根据项目id查找项目中所有的数据，判断是否有文件总表
        List<Project> projectList = projectService.selectProject(project, 0);
        int totalid;
        System.out.println("这是在service的project"+projectList);
        if(projectList.get(0).getfTotalid()==null||projectList.get(0).getfTotalid()==0) {
            Totalfile totalfile = new Totalfile();
            totalfileMapper.insert(totalfile);
            totalid = totalfile.getTotalfileId();
            //将文件总表的id加入project中
            project = projectList.get(0);
            project.setfTotalid(totalid);
            //更新project
            projectService.updateProject(project);
        }else {
            totalid=projectList.get(0).getfTotalid();
        }
            folder.setTotalfileId(totalid);
            folderMapper.insert(folder);
        return folder.getFolderId();
    }

    public int deleteFolder(int folderId) {
        int i = folderMapper.deleteByPrimaryKey(folderId);
        if(i>0){
            return 1;
        }else {
            return 0;
        }
    }

    public int updateFolder(Folder folder) {
        int i = folderMapper.updateByPrimaryKey(folder);
        if(i>0){
            return 1;
        }else {
            return 0;
        }
    }

    public List<Folder> selectFolder(Folder folder, int folderId) {
        List<Folder> folderList = new ArrayList<Folder>();
        if(folderId==0){
            Folder folder1 = folderMapper.selectByPrimaryKey(folder.getFolderId());
            if(folder1!=null){
                folderList.add(folder1);
                return folderList;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    /**
     * 根据总表totalid对文件夹进行查询
     * @return
     */
    public List<Folder> QueryList(int totalid) {
        FolderExample folderExample = new FolderExample();
        folderExample.createCriteria().andTotalfileIdEqualTo(totalid);
        List<Folder> folderList = folderMapper.selectByExample(folderExample);
        if (folderList!=null&&folderList.size()!=0){
            return folderList;
        }
       return null;
    }
}
