package com.controller;

import com.pojo.Comment;
import com.pojo.User;
import com.service.CommentService;
import com.util.AjaxResult;
import com.util.ObtainSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**对评论表进行操作
 * Created by WU on 2017/9/4.
 */
@Controller
@RequestMapping(value = "Comment")
@Transactional
public class CommentController {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    CommentService commentService;

    //向评论表中新增数据用来评论任务的
    //方法是有问题的，有待改进
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult insertComment(HttpServletRequest request,Comment comment){
        // 为Comment补全信息
        User user = new ObtainSession(request).getUser();
        comment.setuId(user.getuId());
        comment.setuName(user.getuName());
        comment.setDiscusId(0);
        //检验输入的数据是否正确
        System.out.println(comment+"insertController--------->");
        // 将数据存入Comment数据库中
        comment = commentService.addComment(comment);
        //检验返回的数据是否正确
        System.out.println(comment+"返回的comment数据--------->");
        if(comment!=null){
            //添加成功就跳进遍历Controllor进行重新遍历
            return new AjaxResult(1,"评论任务成功",comment);
        }
        return new AjaxResult(0,"评论任务失败");
    }

    //向讨论中增加评论
    @RequestMapping("/cContent")
    @ResponseBody
    public AjaxResult insertDiscusComment(HttpServletRequest request,Comment comment){
       //从Session中获取user
        User user=new ObtainSession(request).getUser();
       comment.setuName(user.getuName());
       comment.setuId(user.getuId());
       //因为是对讨论表中评论，所以没有任务什么事
        //根据数据库中 task-id(即任务ID)不能为空，所以设置为0；
        comment.setTaskId(0);
        Comment comment1 = commentService.addComment(comment);
        System.out.println("这是返回的评论对象"+comment1);
        if (comment1!=null){
            return new AjaxResult(1,"成功",comment1);
        }
        return new AjaxResult(0,"失败");
    }



    // TODO 点击任务后会把评论显示出来
    @RequestMapping(value = "queryComment",method = RequestMethod.GET)
    //前台要传过来一个任务ID 即 taskid
    public String queryComment(String taskid,HttpServletRequest request){
        System.out.println(taskid);
        Comment comment=new Comment();
        //将任务ID放到一个评论表中
        comment.setTaskId(Integer.valueOf(taskid));
        List<Comment> commentList = commentService.selectComment(comment, 0);
        if(commentList!=null&&commentList.size()!=0){
            HttpSession session = request.getSession();
            session.setAttribute("commentList",commentList);
            session.setAttribute("taskId",taskid);
            return "comment/querycomment";
        }
        return "comment/fail";
    }

    // TODO 修改
    /**
     * 根据ID对要修改的评论进行查找
     * @param cid
     * @param request
     * @return
     */
    @RequestMapping(value = "selectCommentByID",method = RequestMethod.GET)
    public String selectCommentByID(String cid,HttpServletRequest request)
    {
        Comment comment=new Comment();
        //将页面得到的评论的ID 存入comment对象中
        comment.setcId(Integer.valueOf(cid));
        List<Comment> commentList = commentService.selectComment(comment, 1);
        if(commentList!=null&&commentList.size()!=0){
            //将返回的List存到对象中
            comment=commentList.get(0);
            request.getSession().setAttribute("comment",comment);
            return "comment/updatecommet";
        }
        return "comment/fail";
    }


    /**
     * 修改自己的评论
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateComment")
    public String updateComment(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        //通过Session从页面中得到之前传到页面comment（是未修改的)
        Comment comment = (Comment) session.getAttribute("comment");
        //得到评论修改的内容就是 评论内容
        String cContent=request.getParameter("cContent");
        //将修改的内容放到对象中
        comment.setcContent(cContent);
        //调用update的方法
        int i = commentService.updateComment(comment);
        if (i==1){
            model.addAttribute("taskid",comment.getTaskId());
            return "redirect:queryComment";
        }
        return "comment/fail";
    }

    /**
     *根据ID删除
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteComment" , method = RequestMethod.GET)
    public String deleteComment(HttpServletRequest request,Model model){
        User user =  new ObtainSession(request).getUser();

        HttpSession session = request.getSession();

        //根据ID进行删除
        int i = commentService.deleteComment(Integer.parseInt(request.getParameter("cid")));
        if(i==1)
        {
            model.addAttribute("taskid",session.getAttribute("taskId"));
            return "redirect:queryComment";
        }
        return "comment/fail";
    }
}
