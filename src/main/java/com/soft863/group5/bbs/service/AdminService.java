package com.soft863.group5.bbs.service;

import java.util.Map;

/**管理员业务类
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/16 9:23
 */
public interface AdminService {

    /**
     * 管理员登录
     */
    public Map<String, Object> adminLogin(Integer id, String password);
}
