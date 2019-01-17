package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.dao.ResourceAdminMapper;
import com.soft863.group5.bbs.entity.Resources;
import com.soft863.group5.bbs.service.ResourceAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源管理
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/15 19:58
 */
@Service
public class ResourceAdminServiceImpl implements ResourceAdminService {

    @Autowired
    private ResourceAdminMapper resourceAdminMapper;


    @Override
    public List<Resources> resourcesAll(Integer check) {

        return resourceAdminMapper.queryResources(1);
    }

    @Override
    public void updateResourceCheck(Integer check) {
        resourceAdminMapper.updateResource();
    }

}
