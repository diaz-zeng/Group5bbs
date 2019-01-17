package com.soft863.group5.bbs.dao;


import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.User;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有的积分
     *
     */
    public List<PointRecord> queryPointRecordsByUser(Integer user);

    /**
     *
     * 查询所有的用户
     */
    public List<User> queryAllUser();

    /**
     *
     * 按id查询用户
     *
     * @param id
     * @return
     */
    public User get(Long id);

    /*
    *
    * 添加用户
    *
    *
    * */
    public void insertUser(User user);

    /*
    * 通过名字查找用户
    *
    * */
    public User queryByName(String name);

}
