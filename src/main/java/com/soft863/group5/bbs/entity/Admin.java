package com.soft863.group5.bbs.entity;

import java.io.Serializable;

/**
 * 管理员实体类
 *
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/15 19:28
 */
public class Admin implements Serializable {

    private Long admin_id;//管理员id
    private String admin_name;//管理员账号
    private String admin_password;//管理员密码

    public Admin() {
    }

    public Admin(Long admin_id, String admin_name, String admin_password) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_password = admin_password;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }
}
