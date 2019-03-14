package com.soft863.group5.bbs.dao;

import com.soft863.group5.bbs.entity.Admin;

import java.util.List;

/**
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/16 9:14
 */
public interface AdminMapper {

    /**
     * 根据id查询管理员
     */
    public Admin queryAdmins(String name);
}
