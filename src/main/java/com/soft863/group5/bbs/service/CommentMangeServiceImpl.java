package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.dao.ArticleMapper;
import com.soft863.group5.bbs.dao.CommentManagerMapper;
import com.soft863.group5.bbs.dao.UserMapper;
import com.soft863.group5.bbs.entity.Article;
import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentMangeServiceImpl implements CommentMangeService {
    @Autowired
    private CommentManagerMapper CommentManagerMapper;

    @Autowired
    UserMapper userMapper;


    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> queryAll(Map map) {
        return CommentManagerMapper.queryAllComment(map);
    }

    @Override
    public boolean updatecomment(Integer pass,Long id) {
        Article article = articleMapper.get(id);
        article.setPass(pass);
       return articleMapper.update(article)>0;
    }

    @Override
    public List<PointRecord> paging (String userName,Integer page){
        List<PointRecord> result = new ArrayList<>();
        User user = userMapper.queryByName(userName);
        Integer postion = (page-1)*25;
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("position",postion);
        List<PointRecord> temp = userMapper.queryPointByPage(map);
        if(temp.size()>0){
            result = temp;
        }

        return result;
    }

    @Override
    public Integer queryTotalNum() {
       return   articleMapper.queryTotalNum();
    }

}



































