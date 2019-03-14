package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.Favorite;
import com.soft863.group5.bbs.entity.User;
import com.soft863.group5.bbs.dao.UserMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
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
    public Map<String, Object> addUser(User user) {
        Map<String,Object> map = new HashMap<>();
        Integer count = userMapper.insertUser(user);
        if (count>=1){
            map.put("map",true);
            User user1 = findByName(user.getName());
            addPointRecord(new PointRecord(20,new Date(),"用户注册",user1));
        }else {
            map.put("map",false);
        }
        return map;
    }

    @Override
    public Map<String,Object> queryByName(String name) {
        Map<String,Object> map= new HashMap();
        User user = userMapper.queryByName(name);
        System.out.println(user);
        if(user != null){
            map.put("msg","用户名已被占用");
        }else {
            map.put("msg","用户名可用");
        }
        return map;
    }

    @Override
    public User findByName(String name) {
        User user = userMapper.findByName(name);
        return user;
    }

    /**
     *
     * 通过用户名修改密码
     * */
    @Override
    public Map<String,Object> updatePassword(String password, String username) {
        Map<String,Object> map = new HashMap<>();
        Integer count = userMapper.updatePassword(password,username);
        System.out.println(count);
        if (count>=1){
            map.put("password",true);
        }else {
            map.put("password",false);
        }
        return map;
    }

    @Override
    public Integer addPointRecord(PointRecord pointRecord) {
       return userMapper.addPointRecord(pointRecord);
    }

    @Override
    public Integer userUpadeScore(User user) {
        return userMapper.updateIn(user);
    }

    @Override
    public List<PointRecord> queryUserSocre(Long id) {
        return userMapper.queryPointRecordsByUser(id);
    }


    /**
     * 查询
     * @param resourceid
     * @param userid
     * @return
     */
    @Override
    public boolean queryFavoriteById(long resourceid,long userid) {
        System.out.println(userMapper.queryFavoriteById(resourceid, userid));
        return userMapper.queryFavoriteById(resourceid,userid) == null ?true:false;
    }

    @Override
    public Integer queryUserSocreNum(Long id) {
        return userMapper.queryUserSocreNum(id);
    }

    @Override
    public List<PointRecord> queryUserScoreAll(Map<String, Object> map) {
        return userMapper.queryUserScoreAll(map);
    }



    @Override
    public List<Favorite> queryFavoriteByUserId(long userid) {
        List<Favorite> favorites = userMapper.queryFavoriteByUserId(userid);
        return favorites;
    }

    /**
     *
     * 收藏添加
     * */
    @Override
    public boolean addFavorute(Favorite favorite)throws Exception {

        try {
            return userMapper.addFavorite(favorite)>0;

        } catch (DuplicateKeyException e) {
           return false;
        }
    }


    public User queryById(long id){
        User user = userMapper.queryById(id);
        return user;
    }

    /**
     *
     * 分页
     */

    @Override
    public List<Favorite> queryFavoriteAll(Long userid, Integer start) {
        return userMapper.queryFavoriteAll(userid,start);
    }

    @Override
    public Integer queryFavoriteCount(long userid) {
        return userMapper.queryFavoriteCount(userid);
    }


}
