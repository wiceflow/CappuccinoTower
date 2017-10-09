package com.controller;

import com.dto.TeamforJsp;
import com.pojo.Groupofteam;
import com.service.GroupService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by WU on 2017/9/22.
 */
@Controller
@RequestMapping("/group")
public class GroupController {

   @Autowired
   GroupService groupService;

    /**
     * 添加新的分组
     * @return
     */
    @RequestMapping("/addGroup")
    @ResponseBody
   public AjaxResult addGroup(HttpServletRequest request, @RequestParam("uId[]")int[] uId,
                              Groupofteam groupofteam){
        System.out.println("进入到addGrouop------->Controller");
        //测试
        System.out.println(groupofteam);
        for (int i=0;i<uId.length;i++){
            System.out.println("选中的组员:"+uId[i]);
        }
        //返回为1则成功
        int i = groupService.addGroup(uId, groupofteam);
        if (i==1){
            return new AjaxResult(1,"成功");
        }
        return new AjaxResult(0,"失败");
   }



    /**
     * 根据tid查找分组名
     * @param tId
     * @param request
     * @return
     */
    @RequestMapping("/QueryGroupByTid")
    @ResponseBody
    public AjaxResult QueryGroupByTid(@RequestParam("tId")int tId, HttpServletRequest request){
        System.out.println("进入分组遍历----->");
        Groupofteam groupofteam=new Groupofteam();
        groupofteam.settId(tId);
        List<Groupofteam> groupList = groupService.selectGroup(groupofteam, 0);
        if (groupList!=null){
            System.out.println("返回页面querytid------>");
            System.out.println(groupList.toString());
            return new AjaxResult(1,"查找分组名成功",groupList);
        }
        return new AjaxResult(0,"查找失败");
    }


    /**
     * 跟组gid进行组员的查找
     * @return
     */
    @RequestMapping("/SelectUserByGid")
    @ResponseBody
    public AjaxResult SelectUserByGid(@RequestParam("gId")int gId,HttpServletRequest request){
        System.out.println("进入了SelectUserByGid------->Controller");
        List<TeamforJsp> teamforJspList = groupService.SelectUserByGid(gId);
        if (teamforJspList!=null){
            return new AjaxResult(1,"成功查找出组员",teamforJspList);
        }
        return new AjaxResult(0,"失败查找");
    }
}
