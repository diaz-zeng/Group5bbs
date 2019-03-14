package com.soft863.group5.bbs.dao;

import com.soft863.group5.bbs.entity.Resources;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/15 20:00
 */
public interface ResourceAdminMapper {
    /**
     * 查询全部资源
     */
    public List<Resources> queryResources(@Param("position") Integer position,@Param("check") Integer check);

    /**
     * 审核资源
     */
    public Integer updateResource(@Param("id")Long id, @Param("check") Integer check);

    /**
     * 查询资源的记录条数
     */
    public Integer queryResourcesCount(Integer check);
}
