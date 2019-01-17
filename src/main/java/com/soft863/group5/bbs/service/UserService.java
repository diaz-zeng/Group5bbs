package com.soft863.group5.bbs.service;


import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface UserService {

    /*
    * 查询所有的用户
    */
    public List<User> queryAllUser();

    /*
    *
    * 注册用户
    * */
    public void addUser(User user);

    /*
    * 通过名字查
    * */
    public Map<String,Object> queryByName(String name);










}
