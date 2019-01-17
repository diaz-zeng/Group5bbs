package com.soft863.group5.bbs.dao;

import com.soft863.group5.bbs.entity.ArticleFirstComment;
import com.soft863.group5.bbs.entity.ArticleSecondComment;

import java.util.List;

/**
 * @author Diaz
 * @since 2019/1/16 16:18
 */
public interface ArticleCommentMapper {
    public List<ArticleFirstComment> getCommentsByArticle(Long id);

    public List<ArticleSecondComment> getCommentsByFirst(Long id);

    public Integer saveFirstComment(ArticleFirstComment firstComment);

    public Integer deleteFirstComment(Long id);

    public Integer saveSecondComment(ArticleSecondComment secondComment);

    public Integer deleteSecondComment(Long id);
}
