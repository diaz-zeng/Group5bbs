package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.dao.ArticleMapper;
import com.soft863.group5.bbs.dao.CommentManagerMapper;
import com.soft863.group5.bbs.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.annotation.WebServlet;
import java.util.List;
@Service
public class CommentMangeServiceImpl implements CommentMangeService {
    @Autowired
    private CommentManagerMapper CommentManagerMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> queryAll() {
        return CommentManagerMapper.queryAllComment();
    }

    @Override
    public boolean updatecomment(Integer pass,Long id) {
        Article article = articleMapper.get(id);
        article.setPass(pass);
       return CommentManagerMapper.updateComment(article)>0;
    }

}



































