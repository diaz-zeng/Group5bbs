package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.dao.AdminMapper;
import com.soft863.group5.bbs.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/16 9:24
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Map<String, Object> adminLogin(String name, String password) {
        Map<String,Object> map=new HashMap<>();
        Admin admin = adminMapper.queryAdmins(name);
            if (admin==null||!admin.getAdmin_password().equals(password)){
                map.put("status","error");
            }else {
                map.put("status", "success");
                map.put("admin", admin);
        }
        return map;
    }
}
