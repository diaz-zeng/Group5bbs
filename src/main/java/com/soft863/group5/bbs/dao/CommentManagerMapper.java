package com.soft863.group5.bbs.dao;

import com.soft863.group5.bbs.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentManagerMapper {

    /**
     * 查询所有帖子
     */
    public List queryAllComment();


    /**
     * 审核
     */
    public Integer updateComment(Article article);

}
