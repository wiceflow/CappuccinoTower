package com.controller;

import com.dto.TotalfileforJsp;
import com.service.TatalfileService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**文件总表
 * Created by WU on 2017/9/20.
 */
@Controller
@RequestMapping("total")
public class TotalfileController {
    @Autowired
    TatalfileService tatalfileService;

    /**
     * 根据项目id查找 项目根目录下面包含的文件和文件夹
     * @return
     */
    @RequestMapping("QueryFileByPid")
    @ResponseBody
    public AjaxResult QueryFileByPid(@RequestParam("pId")int pId, HttpServletRequest request){
        System.out.println("进入了QueryFileByPid_________");
        List<TotalfileforJsp> totalfileforJspList = tatalfileService.QueryByPid(pId);
        if(totalfileforJspList!=null){
            for(int i=0;i<totalfileforJspList.size();i++){
                System.out.println(totalfileforJspList.get(i).toString()+"aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                System.out.println(totalfileforJspList.get(i).getFolderName());
            }
            return new AjaxResult(1,"遍历成功",totalfileforJspList);
        }
        return new AjaxResult(0,"失败");
    }
}
