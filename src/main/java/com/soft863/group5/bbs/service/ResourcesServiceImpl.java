package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.dao.ResourcesMapper;
import com.soft863.group5.bbs.entity.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * author zhaosl
 * date 2019/1/15 20:54
 *
 * @version 1.0
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    public ResourcesServiceImpl(){}

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public Resources queryResourcesById(Long id) {
        return resourcesMapper.queryResourcesById(id);
    }

    @Override
    public Resources queryResourcesByName(String name) {
         return resourcesMapper.queryResourcesByName(name);
    }

    @Override
    public Resources queryResourcesByNameLike(String name) {
        return resourcesMapper.queryResourcesByNameLike("%"+name+"%");
    }

    @Override
    public List<Resources> queryAllResources() {
        return resourcesMapper.queryAllResources();
    }

    @Override
    public List<Resources> queryAllResourcesByPage(Map<String, Object> map) {
        return resourcesMapper.queryAllResourcesByPage(map);
    }

    @Override
    public Integer addResources(Resources resources) {
        return resourcesMapper.addResources(resources);
    }

    @Override
    public Integer deleteResources(Long id) {
        return resourcesMapper.deleteResources(id);
    }

    @Override
    public Integer updateResources(Resources resources) {
        return resourcesMapper.updateResources(resources);
    }

    @Override
    public Integer queryResourcesCount() {
        return resourcesMapper.queryResourcesCount();
    }




}
