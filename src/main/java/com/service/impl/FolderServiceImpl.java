package com.service.impl;

import com.dao.FolderMapper;
import com.pojo.Folder;
import com.pojo.FolderExample;
import com.service.FolderService;
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
    public int addFolder(Folder folder) {
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

    public List<Folder> QueryList() {
        List<Folder> folderList = null;
        FolderExample folderExample = new FolderExample();
        folderExample.setDistinct(true);
        folderList = folderMapper.selectByExample(folderExample);
        return folderList;
    }
}
