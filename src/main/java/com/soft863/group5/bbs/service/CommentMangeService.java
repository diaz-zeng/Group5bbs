package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.entity.Article;
import com.soft863.group5.bbs.entity.PointRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CommentMangeService {
    /**
     * 查询全部
     * @return
     */
    public List<Article> queryAll(Map map);

    /**
     * 审核
     * @return
     */
    public boolean updatecomment(Integer pass,Long id);

    public List<PointRecord> paging (String userName, Integer page);

    public Integer queryTotalNum();
}






























