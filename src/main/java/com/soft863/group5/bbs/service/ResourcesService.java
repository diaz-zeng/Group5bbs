package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.entity.Resources;

import java.util.List;
import java.util.Map;

/**
 * author zhaosl
 * date 2019/1/15 20:54
 *
 * @version 1.0
 */
public interface ResourcesService {

    public Resources queryResourcesById(Long id);

    /**
     * 按资源的名字查询资源
     * @param name
     * @return
     */
    public Resources queryResourcesByName(String name);

    /**
     * 按照资源的名字做模糊查询
     * @param name
     * @return
     */
    public Resources queryResourcesByNameLike(String name);

    public List<Resources> queryAllResources();

    public List<Resources> queryAllResourcesByPage(Map<String,Object> map);

    /**
     * 添加用户
     * @param resources
     */
    public Integer addResources(Resources resources);

    /**
     * 按照资源id删除
     * @param id
     * @return Integer
     */
    public Integer deleteResources(Long id);

    /**
     * 修改资源
     * @param resources
     * @return
     */
    public Integer updateResources(Resources resources);

    /**
     *查询记录的条数
     * @return Integer
     */
    public Integer queryResourcesCount();
}
