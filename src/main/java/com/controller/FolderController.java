package com.controller;

import com.pojo.File;
import com.pojo.Folder;
import com.service.DynamicService;
import com.service.FileService;
import com.service.FolderService;
import com.util.AjaxResult;
import com.util.DynamicTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private DynamicService dynamicService;

    @RequestMapping(value = "AddFolder",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult AddFolder(Folder folder, HttpServletRequest request, @RequestParam("pId")int pId){
        try{
            int folderid = folderService.addFolder(folder,pId);
            folder.setFolderId(folderid);
            request.getSession().setAttribute("folderid",folderid);
            int i = folderid;
            //动态操作
            DynamicTool d = new DynamicTool(i,"folder","新建了一个文件夹",request,dynamicService);
            d.newDynamic();
            //返回1，表示增加文件夹成功
            return new AjaxResult(1,"增加文件夹成功",folder);
        }catch (Exception e){
            e.printStackTrace();
            //返回0，表示增加文件夹失败
            return new AjaxResult(0,"增加文件夹失败");
        }

    }

    @RequestMapping(value = "FolderList",method = RequestMethod.GET)
    public AjaxResult FolderList(HttpServletRequest request){
        List<Folder> folderList = folderService.QueryList(1);
        request.getSession().setAttribute("folderList",folderList);
        return new AjaxResult(1,"取出文件夹列表成功");
    }

    @RequestMapping(value = "FolderInfo",method = RequestMethod.GET)
    public AjaxResult FolderInfo(Folder folder,String folderId,HttpServletRequest request){
        folder.setFolderId(Integer.valueOf(folderId));
        List<Folder> folderList = folderService.selectFolder(folder,0);
        if(folderList!=null){
            Folder folder1 = folderList.get(0);
            request.getSession().setAttribute("folder1",folder1);
            //返回1，表示查询文件夹成功
            return new AjaxResult(1,"查询文件夹信息成功");
        } else{
            //返回0，表示查询文件夹失败
            return new AjaxResult(0,"查询文件夹失败");
        }
    }

    @RequestMapping(value = "UpdateFolder",method = RequestMethod.POST)
    public AjaxResult UpdateFolder(Folder folder,HttpServletRequest request){
        folder.setFolderId(folder.getFolderId());
        int m = folder.getFolderId();
        int i = folderService.updateFolder(folder);
        if(i==1){
            //动态操作
            DynamicTool d = new DynamicTool(m,"folder","更新了一个文件夹",request,dynamicService);
            d.newDynamic();
            //返回1，表示更新文件夹成功
            return new AjaxResult(1,"更新文件夹成功");
        }else{
            //返回0，表示更新文件夹失败
            return new AjaxResult(0,"更新文件夹失败");
        }
    }

    @RequestMapping(value ="DeleteFolder",method = RequestMethod.GET)
    public AjaxResult DeleteFolder(String folderId,HttpServletRequest request){
        int i = folderService.deleteFolder(Integer.parseInt(folderId));
        int m = Integer.parseInt(folderId);
        if(i==1){
            //动态操作
            DynamicTool d = new DynamicTool(m,"folder","删除了一个文件夹",request,dynamicService);
            d.newDynamic();
            //返回1，表示删除文件夹成功
            return new AjaxResult(1,"删除文件夹成功");
        }else{
            //返回0，表示删除文件夹失败
            return new AjaxResult(0,"删除文件夹失败");
        }
    }


    @RequestMapping("/queryFileByFolderId")
    @ResponseBody
    public AjaxResult queryFileByFolderId(@RequestParam("folderId")int folderId){
        System.out.println("进入了queryFileByFolderId------>Controller");
        List<File> fileList = folderService.queryFileByFolderId(folderId);
        if(fileList!=null){
            return new AjaxResult(1,"成功",fileList);
        }
        return new AjaxResult(0,"失败");
    }
}
