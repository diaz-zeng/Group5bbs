package com.soft863.group5.bbs.dao;

import com.soft863.group5.bbs.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * @author Diaz
 * @since 2019/1/16 10:02
 */
public interface ArticleMapper {

    /**
     * 查询所有的文章
     *
     * @return
     */
    public List<Article> queryAll();

    /**
     * 分页查询
     *
     * @param map 分页信息 size：分页大小 position：当前位置
     * @return
     */
    public List<Article> queryAllByPage(Map<String, Object> map);


    /**
     * 通过id获取一个对象
     *
     * @param id
     * @return
     */
    public Article get(Long id);

//    public List<Article> queryList(Long flag);

    /**
     * 通过id删除一个对象
     *
     * @param id
     * @return
     */
    public Integer delete(Long id);

    /**
     * 保存一个对象
     *
     * @param article
     * @return
     */
    public Integer save(Article article);

    /**
     * 更新一个对象
     *
     * @param article
     * @return
     */
    public Integer update(Article article);

    /**
     * 按用户查询文章
     *
     * @param userId
     * @return
     */
    public List<Article> queryByUser(Long userId);

    /**
     * 查询总页码数，分类查询
     *
     * @param pass 文章状态（0：待审核，1：审核通过，-1：审核不通过）
     * @return
     */
    public Integer getCount(Integer pass);

     public  Integer queryTotalNum();
}
