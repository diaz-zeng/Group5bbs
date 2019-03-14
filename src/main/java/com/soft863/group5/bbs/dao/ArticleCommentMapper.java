package com.soft863.group5.bbs.dao;

import com.soft863.group5.bbs.entity.ArticleFirstComment;
import com.soft863.group5.bbs.entity.ArticleSecondComment;

import java.util.List;

/**
 * 发帖评论持久化层
 *
 * @author Diaz
 * @since 2019/1/16 16:18
 */
public interface ArticleCommentMapper {
    /**
     * 按照文章id查询一级评论
     *
     * @param id
     * @return
     */
    public List<ArticleFirstComment> queryFirstCommentByArticle(Long id);

    /**
     * 查询单条一级评论
     *
     * @param id
     * @return
     */
    public ArticleFirstComment getFirstComment(Long id);

    /**
     * 保存一条一级评论
     *
     * @param firstComment
     * @return
     */
    public Integer saveFirstComment(ArticleFirstComment firstComment);

    /**
     * 删除一条一级评论
     *
     * @param id
     * @return
     */
    public Integer deleteFirstComment(Long id);

    /**
     * 查询一级评论下的二级评论
     *
     * @param id 一级评论的id
     * @return
     */
    public List<ArticleSecondComment> queryCommentByComment(Long id);

    /**
     * 查询一条二级评论
     *
     * @param id
     * @return
     */
    public ArticleSecondComment getSecondComment(Long id);

    /**
     * 保存一条二级评论
     *
     * @param secondComment
     * @return
     */
    public Integer saveSecondComment(ArticleSecondComment secondComment);

    /**
     * 删除一条二级评论
     *
     * @param id
     * @return
     */
    public Integer deleteSecondComment(Long id);


}
