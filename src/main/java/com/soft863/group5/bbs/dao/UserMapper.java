package com.soft863.group5.bbs.dao;


import com.soft863.group5.bbs.entity.Favorite;
import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.Favorite;
import com.soft863.group5.bbs.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 查询所有的积分
     */
    public List<PointRecord> queryPointRecordsByUser(Long id);

    /**
     * 查询所有的用户
     */
    public List<User> queryAllUser();

    /**
     * 按id查询用户
     *
     * @param id
     * @return
     */
    public User queryById(Long id);

    /**
     * 添加用户
     */
    public Integer insertUser(User user);

    /**
     * 通过名字查找用户
     */
    public User queryByName(String name);

    public User findByName(String name);

    /**
     * 按用户名修改账户密码
     */
    public Integer updatePassword(String password, String name);

    /**
     * 更新积分
     * sunlei
     */
    public Integer updateIn(User user);

    /**
     * 添加积分
     *
     * @param pointRecord
     */
    public Integer addPointRecord(PointRecord pointRecord);

    /**
     * 查询积分
     * @param id
     * @return
     */
    public List<PointRecord> queryPointRecordsByUser(long id);

    /**
     * 收藏添加
     */
    Integer addFavorite(Favorite favorite);






    List<PointRecord> queryPointByPage(Map<String,Object> map);

    /**
     * 查询是否添加过
     * @param resourceid
     * @param userid
     * @return
     */
    Favorite queryFavoriteById(long resourceid,long userid);
    /**
     *
     * 映射结果集
     *
     * */
    List<Favorite> queryFavoriteByUserId(long userid);

    /**
     * 分页查询用户积分
     * @param map
     * @return
     */
    public List<PointRecord> queryUserScoreAll(Map<String, Object> map);

    /**
     * 根据id查询用户积分的总条数
     * @param id
     * @return
     */
    public Integer queryUserSocreNum(Long id);

    /**
     *
     * 分页
     */
    public List<Favorite> queryFavoriteAll(@Param("userid") Long userid,@Param("start") Integer start);

    /**
     * 查找收藏的总数
     */
    public Integer queryFavoriteCount(long userid);
}
