package com.service.impl;

import com.dao.CommentMapper;
import com.pojo.Comment;
import com.pojo.CommentExample;
import com.service.CommentService;
import com.util.TimeGetTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 对应评论表的Service实现类
 * [CommentMapper] [CommentService]
 * Created by WU on 2017/9/4.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    //注入评论表Mapper
    @Autowired
    CommentMapper commentMapper;
    /**
     *新增一个评论表
     * @param comment 一个评论表
     * @return
     */
    public Comment addComment(Comment comment) {
        // 调用工具类获取系统当前时间并转换成Date格式
        TimeGetTrans time=new TimeGetTrans();
        // 测试一下时间是否正确
        System.out.println();
        //将获取的时间放到 comment
        comment.setcTime(time.getTime());
        //判断一下是对任务的评论还是对讨论的评论
        //如果讨论的id为空，则证明是对任务的评论
        if (comment.getDiscusId()==null) {
          //这里是对任务评论的一些操做
          //有待改进
        }
            //插入一个新的数据
            commentMapper.insert(comment);
        return comment;
    }

    public Comment addComment(Comment comment, int Type) {
        return null;
    }

    /**
     *根据ID进行删除
     * @param cId 根据Id进行删除
     * @return
     */
    public int deleteComment(int cId) {
        commentMapper.deleteByPrimaryKey(cId);
        return 1;
    }

    /**
     * 对评论表的内容进行修改
     * @param comment 评论表实体类
     * @return
     */
    public int updateComment(Comment comment) {
        //调用时间工具。修改时也要将时间修改
        TimeGetTrans timeGetTrans=new TimeGetTrans();
        comment.setcTime(timeGetTrans.getTime());
        //调用修改方法
        commentMapper.updateByPrimaryKey(comment);
        return 1;
    }

    /**
     * 多种查询方法
     * @param comment 评论表实体类
     * @param cId  根据id进行查找
     * @return
     */
    public List<Comment> selectComment(Comment comment, int cId) {

     List<Comment> commentList=new ArrayList<Comment>();

    //根据任务ID(taskId)进行查找，并且按照时间进行排序
    if(cId==0){
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andTaskIdEqualTo(comment.getTaskId());
        //按照时间进行降序的排序
        commentExample.setOrderByClause("c_time DESC");
        commentList=commentMapper.selectByExample(commentExample);
        if(commentList!=null&&commentList.get(0).getuName()!=null){
            return commentList;
        }
    }

    //根据评论表的ID进行查找
    if(cId==1)
    {
        Comment comment1 = commentMapper.selectByPrimaryKey(comment.getcId());
        commentList.add(comment1);
        if(commentList!=null&&commentList.get(0).getuName()!=null){
            return commentList;
        }

    }

    //根据讨论表的ID进行查找
    if (cId==2){
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andDiscusIdEqualTo(comment.getDiscusId());
        commentList= commentMapper.selectByExample(commentExample);
        if (commentList!=null&&commentList.get(0).getcId()!=null){
            return commentList;
        }
    }
        return null;
    }
}
