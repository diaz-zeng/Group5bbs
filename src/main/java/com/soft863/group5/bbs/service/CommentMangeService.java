package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentMangeService {
    /**
     * 查询全部
     * @return
     */
    public List<Article> queryAll();

    /**
     * 审核
     * @return
     */
    public boolean updatecomment(Integer pass,Long id);

}






























