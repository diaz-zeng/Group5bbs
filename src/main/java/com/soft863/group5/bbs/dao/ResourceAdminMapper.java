package com.soft863.group5.bbs.dao;

import java.util.List;

/**
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/15 20:00
 */
public interface ResourceAdminMapper {
    /**
     * 查询全部资源
     */
    public List queryResources(Integer check);

    /**
     * 撤销资源
     */
    public void delectResource(Integer id);

    /**
     * 审核资源
     */
    public void updateResource();

}
