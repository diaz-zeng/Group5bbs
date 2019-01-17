package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.entity.User;
import com.soft863.group5.bbs.dao.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /*
     * 查询所有的用户
     */
    @Override
    public List<User> queryAllUser() {
        List<User> users = userMapper.queryAllUser();
        return users;
    }

    @Override
    public void addUser(User user) {
       userMapper.insertUser(user);
    }

    @Override
    public Map<String,Object> queryByName(String name) {
        Map<String,Object> map= new HashMap();
        User user = userMapper.queryByName(name);
        if (user==null){
           map.put("msg","用户名可用");
           return map;
        }else {
           map.put("msg","用户名已存在");
           return map;
        }
    }


}
