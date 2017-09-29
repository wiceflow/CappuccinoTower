package com.controller;

import com.pojo.Dynamic;
import com.pojo.User;
import com.service.DynamicService;
import com.util.AjaxResult;
import com.util.ObtainSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 小灯泡实时提醒功能
    先需要将用户每次退出登录的时间记录起来！
    user --> OutLoginTime
    如何判断用户退出
    1）判断session；
    2）心跳  不会
 * 1.有关我的项目的新动态都提醒我
 * 2.如果是动态有指定人，则显示指定了我的信息
 * Created by BF on 2017/9/25.
 */
@Controller
public class BulbController {

    private User user;

    @Autowired
    private DynamicController controller;
    @Autowired
    private DynamicService dynamicService;

    public static List<Dynamic> getDL1() {
        return DL1;
    }

    public static void setDL1(List<Dynamic> DL1) {
        BulbController.DL1 = DL1;
    }

    public static List<Dynamic> getDL2() {
        return DL2;
    }

    public static void setDL2(List<Dynamic> DL2) {
        BulbController.DL2 = DL2;
    }

    // 全局变量
    private static List<Dynamic> DL1 = new ArrayList<Dynamic>();
    // 这个用来每次进行查询
    private static List<Dynamic> DL2 = new ArrayList<Dynamic>();

    /**
     * 灯泡读取
     * @param request
     * @return
     */
    //TODO 需要考虑一个问题，自己添加动态不会显示，别人添加动态才会显示
    public AjaxResult abc(HttpServletRequest request){
        user = new ObtainSession(request).getUser();
        //DL2 = dynamicService.bulbQuery(user.getuId());
        if (DL2==null){
            return null;
        }
        if (getDL1()==null||getDL1().size()==0){
            setDL1(DL2);
        }
        // 获取用户最后登录时间
        //.......................


        // DL2数组肯定是大于等于DL1数组  多出来的部分就是新的灯泡信息
        int len1 = getDL1().size();
        int len2 = getDL2().size();
        // 循环处理显示
        for (int i=len1;i<len2;i++){
            // 新的提醒信息 这里处理一下；
            Dynamic d = getDL2().get(i);
            // 进行操作
        }

        return null;
    }



}
