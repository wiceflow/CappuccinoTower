package com.service;

import com.pojo.Comment;

import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 对应 评论表 的接口
 *  [CommentMapper]
 */
public interface CommentService {

    /**
     * 新增一个新的讨论
     * @param comment 一个讨论表
     * @return 返回0表示失败，返回1表示成功
     */
    int addComment(Comment comment);

    /**
     * 删除一个讨论表
     * @param cId 根据Id进行删除
     * @return 返回0表示失败，返回1表示成功
     */
    int deleteComment(int cId);

    /**
     * 修改一个讨论表
     * @param comment 讨论表实体类
     * @return 返回0表示失败，返回1表示成功
     */
    int updateComment(Comment comment);

    /**
     * 查找讨论表，或遍历讨论表
     * @param comment 讨论表实体类
     * @param cId  根据id进行查找
     * @return
     */
    List<Comment> selectComment(Comment comment,int cId);
}
