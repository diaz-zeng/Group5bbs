package com.soft863.group5.bbs.controller;

import com.soft863.group5.bbs.entity.Resources;
import com.soft863.group5.bbs.service.ResourceAdminService;
import com.soft863.group5.bbs.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 资源管理控制
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/15 19:55
 */
@Controller
@RequestMapping("resourceadmin")
public class ResourceAdminController {

    @Autowired
    private ResourceAdminService resourceAdminService;

    @Autowired
    private ResourcesService resourcesService;
    /**
     * 未审核界面
     * @return
     */
    @RequestMapping("unaudited")
    public String unaudited(HttpServletRequest request){
        List<Resources> resourcesAll = resourceAdminService.resourcesAll(1);
        request.setAttribute("sources",resourcesAll);
        return "resource-source";
    }

    /**
     * 资源已发布页面
     * @param request
     * @return
     */
    @RequestMapping("release")
    public String release(HttpServletRequest request){
        List<Resources> resourcesAll = resourceAdminService.resourcesAll(2);
        request.setAttribute("releases",resourcesAll);
        return "resource-release";
    }
    @RequestMapping("failed")
    public String failed(HttpServletRequest request){
        List<Resources> resourcesAll = resourceAdminService.resourcesAll(3);
        request.setAttribute("failed",resourcesAll);
        return "resource-failed";
    }

    @RequestMapping("remove")
    public String remove(long id){
        resourcesService.deleteResources(id);
        return "resourceadmin/unaudited.action";
    }

}
