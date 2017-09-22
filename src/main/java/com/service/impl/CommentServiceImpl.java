package com.service.impl;

import com.dao.CommentMapper;
import com.pojo.Comment;
import com.pojo.CommentExample;
import com.service.CommentService;
import com.util.TimeGetTrans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CommentServiceImpl implements CommentService {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(CommentServiceImpl.class);

    //注入评论表Mapper
    @Autowired
    CommentMapper commentMapper;

    /**
     * 新增一个评论表
     * @param comment 一个评论表
     * @param Type 评论条件
     * @return
     */
    public Comment addComment(Comment comment, int Type) {
        // 调用工具类获取系统当前时间并转换成Date格式
        TimeGetTrans time = new TimeGetTrans();
        // 将获取的时间放到 comment
        comment.setcTime(time.getTime());
        // 判断是否是评论他人的 回复，若不是，则给设置一个默认值0
        if (Type==1){
            List<Comment> cList = selectComment(comment,2);
            if (cList!=null&&cList.get(0).getuName()!=null){
                comment.setBuUsername(cList.get(0).getuName());
                comment.setBuId(cList.get(0).getuId());
            }
        }
        // 即bUid 和 bCid 为0 方便后面的调用
        if (comment.getBuId() == null || comment.getBuId().equals("")) {
            comment.setBuId(0);
            comment.setBcId(0);
        }
        try {
            // 插入一个新的数据
            commentMapper.insert(comment);
            return comment;
        }catch (Exception e){
            _LOG.error(time.getTime() + ": 新增评论出错");
            return null;
        }

    }

    /**
     * 根据ID进行删除
     *
     * @param cId 根据Id进行删除
     * @return
     */
    public int deleteComment(int cId) {
        commentMapper.deleteByPrimaryKey(cId);
        return 1;
    }

    /**
     * 对评论表的内容进行修改
     *
     * @param comment 评论表实体类
     * @return
     */
    public int updateComment(Comment comment) {
        //调用时间工具。修改时也要将时间修改
        TimeGetTrans timeGetTrans = new TimeGetTrans();
        comment.setcTime(timeGetTrans.getTime());
        //调用修改方法
        commentMapper.updateByPrimaryKey(comment);
        return 1;
    }

    /**
     * 多种查询方法
     *
     * @param comment 评论表实体类
     * @param cId     根据id进行查找
     * @return
     */
    public List<Comment> selectComment(Comment comment, int cId) {

        List<Comment> commentList = new ArrayList<Comment>();

        // 根据任务ID(taskId)进行查找，并且按照时间进行排序 [遍历]
        if (cId == 0) {
            CommentExample commentExample = new CommentExample();
            commentExample.createCriteria().andTaskIdEqualTo(comment.getTaskId());
            //按照时间进行降序的排序
            commentExample.setOrderByClause("c_time DESC");
            commentList = commentMapper.selectByExample(commentExample);
            if (commentList != null && commentList.get(0).getuName() != null) {
                return commentList;
            }
        }

        // 根据评论表的ID进行查找
        if (cId == 1) {
            Comment comment1 = commentMapper.selectByPrimaryKey(comment.getcId());
            System.out.println(comment.getcId());
            System.out.println(comment.toString());
            commentList.add(comment1);
            if (commentList != null && commentList.get(0).getuName() != null) {
                return commentList;
            }
        }

        // 根据被评论编号进行查找
        if (cId == 2)
        {
            CommentExample commentExample = new CommentExample();
            // 根据被评论ID进行查找
            commentExample.createCriteria().andBcIdEqualTo(comment.getBcId());
            commentList = commentMapper.selectByExample(commentExample);
            if (commentList != null && commentList.get(0).getuName() != null)
                return commentList;
        }
        return null;
    }
}
