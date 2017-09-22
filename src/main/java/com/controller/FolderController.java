package com.controller;

import com.pojo.Folder;
import com.service.FolderService;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by chen on 2017/9/6.
 * 文件夹控制器
 */
@Controller
@RequestMapping(value = "Folder")
@Transactional
public class FolderController {

    @Autowired
    FolderService folderService;

    @RequestMapping(value = "AddFolder",method = RequestMethod.POST)
    public String AddFolder(Folder folder, HttpServletRequest request){
        int folderid = folderService.addFolder(folder);
        request.getSession().setAttribute("folderid",folderid);
        return "AllSuccess";
    }

    @RequestMapping(value = "FolderList",method = RequestMethod.GET)
    public String FolderList(HttpServletRequest request){
        List<Folder> folderList = folderService.QueryList();
        request.getSession().setAttribute("folderList",folderList);
        return "folder/folderlist";
    }

    @RequestMapping(value = "FolderInfo",method = RequestMethod.GET)
    public String FolderInfo(Folder folder,String folderId,HttpServletRequest request){
        folder.setFolderId(Integer.valueOf(folderId));
        List<Folder> folderList = folderService.selectFolder(folder,0);
        if(folderList!=null){
            Folder folder1 = folderList.get(0);
            request.getSession().setAttribute("folder1",folder1);
            return "folder/folderinfo";
        } else{
            return "AllFail";
        }
    }

    @RequestMapping(value = "UpdateFolder",method = RequestMethod.POST)
    public String UpdateFolder(Folder folder){
        folder.setFolderId(folder.getFolderId());
        int i = folderService.updateFolder(folder);
        if(i==1){
            return "redirect:FolderList";
        }else{
            return "AllFail";
        }
    }

    @RequestMapping(value ="DeleteFolder",method = RequestMethod.GET)
    public String DeleteFolder(String folderId){
        int i = folderService.deleteFolder(Integer.parseInt(folderId));
        if(i==1){
            return "redirect:FolderList";
        }else{
            return "AllFail";
        }
    }
}
