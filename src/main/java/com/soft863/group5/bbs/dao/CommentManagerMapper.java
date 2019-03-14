package com.soft863.group5.bbs.dao;

import com.soft863.group5.bbs.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentManagerMapper {

    /**
     * 查询所有帖子
     */
    public List queryAllComment(Map map);


    /**
     * 审核
     */
    public Integer updateComment(Article article);

}
