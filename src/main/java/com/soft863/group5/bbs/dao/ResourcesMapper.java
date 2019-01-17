package com.soft863.group5.bbs.dao;

import com.soft863.group5.bbs.entity.Resources;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * author zhaosl
 * date 2019/1/15 17:45
 *
 * @version 1.0
 */
public interface ResourcesMapper {
    /**
     * 按照资源的id查找资源信息
     * @param id
     * @return Resources
     */
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

    /**
     * 查找所有Resources的对象，放入List集合里
     * @return List
     */
    public List<Resources> queryAllResources();

    /**
     * 分页查找Resources对象
     * @param map
     * @return
     */
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
     *
     * @return Integer
     */
    public Integer queryResourcesCount();
}
