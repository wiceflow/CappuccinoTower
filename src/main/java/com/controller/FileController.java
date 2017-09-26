package com.controller;

import com.service.DynamicService;
import com.service.FileService;
import com.util.AjaxResult;
import com.util.DynamicTool;
import com.util.ObtainSession;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by chen on 2017/8/30.
 * 文件控制层
 * TODO 还没整合文件总表 没有编写
 */
@RequestMapping("/file")
@Controller
@Transactional
public class FileController {

    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(FileController.class);
    @Autowired
    private FileService fileService;
    @Autowired
    private DynamicService dynamicService;

    /**
     * 上传文件Controller
     * @param file springMVC 文件上传控件
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "uploadfile")
    @ResponseBody
    public AjaxResult doUpload(@RequestParam(value = "file",required = false) MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("进入上传文件的conlller");
        int pId=new ObtainSession(request).getProject().getpId();
        System.out.println("得到项目id"+pId);
        if (!file.isEmpty()) {
            System.out.println("进入了file");
            //获取文件名
            String fileName = file.getOriginalFilename();
            // 获取存放路径
            String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
            com.pojo.File file1 = new com.pojo.File();
            file1.setFileUrl(filePath);
            file1.setFileName(fileName);
            // 将文件数据存入数据库
            file1 = fileService.addFile(file1,pId);
            if(file1!=null){
                _LOG.info("FileController中把文件存入数据库成功！");
                //动态-->将操作信息存入动态表
                //动态操作
                int i = file1.getFileId();
                DynamicTool d = new DynamicTool(i,"file","上传了一个文件",request,dynamicService);
            }else if(file1==null){
                _LOG.error("FileController中文件存入数据库失败");
            }
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath, fileName));
            }catch (Exception e){
                _LOG.error("文件流输入发生错误");
                throw new IOException();
            }
            //返回1，表示上传成功
            return new AjaxResult(1,"上传成功",file1);
        }
        //返回0，表示上传失败
        return new AjaxResult(0,"上传失败");
    }

    /**
     * 列出上传的文件
     * @param request
     * @return
     */
    @RequestMapping(value = "listfile")
    public AjaxResult listfile(HttpServletRequest request){
        // 返回所有的file
        List<com.pojo.File> fileList = fileService.QueryList(1);
        if (fileList==null||fileList.size()==0){
            _LOG.error("取出文件列表时候为空");
            throw new NullPointerException();
        }
        //TODO 单例模式存取数据
        ModelAndView modelAndView = new ModelAndView();
        //将List放到ModelandView中
        modelAndView.addObject("fileList",fileList);
        modelAndView.setViewName("File/filelist");
        //返回1，表示取出文件列表成功
        return new AjaxResult(1,"取出文件列表成功");
    }

    /**
     * 下载文件
     * @param request
     * @param response
     */
    @RequestMapping(value = "downloadfile" ,method = RequestMethod.GET)
    public AjaxResult downloadfile(HttpServletRequest request, HttpServletResponse response){
        System.out.println("1");
        int fileId = Integer.parseInt(request.getParameter("fileid"));
        com.pojo.File file2 = new com.pojo.File();
        //根据ID查询当前文件名
        List<com.pojo.File> fileList = fileService.selectFile(String.valueOf(file2),fileId);
        //com.pojo.File file1 = new com.pojo.File();
        com.pojo.File file1=fileList.get(0);
        //得到要下载的文件名
        String fileName = file1.getFileName();
        String filePath = file1.getFileUrl();
        System.out.println("2");
        try{
            fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
            System.out.println("3");
            //获取上传文件的目录

            //得到要下载的文件
            File file = new File(filePath+"\\"+fileName);
            int i = file1.getFileId();
            //动态-->将操作信息存入动态表，因为用到session所以在controller中控制，不再去service中控制，减少代码使用
            //动态操作
            DynamicTool d = new DynamicTool(i,"file","下载了一个文件",request,dynamicService);
            d.newDynamic();

            //如果文件不存在
            System.out.println(!file.exists());
            if(!file.exists()){
                request.setAttribute("message","资源已删除");
                System.out.println("资源已删除");
                //返回0，表示文件下载失败
                return new AjaxResult(0,"文件已删除");
            }
            //处理文件名
            /*String realname = fileName.substring(fileName.indexOf("_")+1);*/
            //设置响应头，控制浏览器下载该文件
            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
            //读取要下载的文件，保存到文件输入流
            FileInputStream in = new FileInputStream(file);
            //创建输出流
            OutputStream out = response.getOutputStream();
            //创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            //循环将输入流中的内容读取到缓冲区当中
            while((len = in.read(buffer))>0){
                //输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer,0,len);
            }
            //关闭文件输入流
            in.close();
            //关闭输出流
            out.close();
            return new AjaxResult(1,"文件下载成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除文件
     * @param fileId
     * @param request
     * @return
     */
    @RequestMapping(value = "deletefile",method = RequestMethod.GET)
    public AjaxResult deletefile(int fileId,HttpServletRequest request){
        try{
            fileService.deleteFile(fileId);
            int i = fileId;
            //动态操作
            DynamicTool d = new DynamicTool(i,"file","删除了一个任务",request,dynamicService);
            d.newDynamic();
            //返回1，表示删除文件成功
            return new AjaxResult(1,"删除文件成功");
        }catch (Exception e){
            _LOG.error("FileController层删除文件出错！");
            return new AjaxResult(0,"删除文件失败");
        }
    }
}
