package com.soft863.group5.bbs.service;

import com.oracle.deploy.update.UpdateCheck;
import com.soft863.group5.bbs.entity.Resources;

import java.util.List;

/**
 * 资源管理
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/15 19:57
 */
public interface ResourceAdminService {

    /**
     * 查询全部资源
     * @return
     */
    public List<Resources> resourcesAll(Integer check);

    /**
     * 修改check审核资源
     * @param check 资源审核值
     */
    public void updateResourceCheck(Integer check);


}
