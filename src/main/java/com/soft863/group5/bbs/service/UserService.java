package com.soft863.group5.bbs.service;


import com.soft863.group5.bbs.entity.Favorite;
import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.Favorite;
import com.soft863.group5.bbs.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {
    /**
     *
     * @param
     * @return
     *
     */
    boolean addFavorute(Favorite favorite) throws Exception;

    /**
     *
     * 通过id查用户
     * */
    public User queryById(long id);

    /**
    * 查询所有的用户
    */
    public List<User> queryAllUser();

    /**
    *
    * 注册用户
    * */
    public Map<String,Object> addUser(User user);

    /**
    * 通过名字查
    * */
    public Map<String,Object> queryByName(String name);

    /***
     *
     * 登陆时查找用户
     * */
    public User findByName(String name);

    /**
     *
     * 通过账户名修改密码
     **/
    public Map<String,Object> updatePassword(String password,String username);


    /**
     * 添加积分
     * @param pointRecord
     */
    public Integer addPointRecord(PointRecord pointRecord);

    /**
     * 更新用户积分
     * @param user
     * @return
     */
    public Integer userUpadeScore(User user);

    /**
     * 查询用户积分
     * @param id
     * @return
     */
    public List<PointRecord> queryUserSocre(Long id);


    /**
     *
     * 查询收藏表
     */
    public boolean queryFavoriteById(long resourceid,long userid);

    /**
     *
     * 展示个人收藏
     * */
    public List<Favorite> queryFavoriteByUserId(long userid);




    public Integer queryUserSocreNum(Long id) ;


    public List<PointRecord> queryUserScoreAll(Map<String, Object> map) ;

    /**
     * 分页
     */
    public List<Favorite> queryFavoriteAll(Long userid,Integer start);

    public Integer queryFavoriteCount(long userid);
}
