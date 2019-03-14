package com.soft863.group5.bbs.controller;

import com.soft863.group5.bbs.entity.Pagination;
import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.Resources;
import com.soft863.group5.bbs.entity.User;
import com.soft863.group5.bbs.service.ResourceAdminService;
import com.soft863.group5.bbs.service.ResourcesService;
import com.soft863.group5.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private UserService userService;
    /**
     * 未审核界面
     * @return
     */
    @RequestMapping("unaudited")
    public ModelAndView unaudited(Integer page){
        ModelAndView mv=new ModelAndView();
        if (page==null||"".equals(page)){
            page=1;
        }
        List<Resources> resourcesAll = resourceAdminService.resourcesAll((page-1)*25,0);
        mv.addObject("resourcesAll",resourcesAll);
        mv.addObject("page", page);
        mv.addObject("pageCount", resourceAdminService.resourcesCount(0));
        mv.setViewName("resource-source");
        return mv;
    }

    /**
     * 资源已发布页面
     * @param
     * @return
     */
    @RequestMapping("release")
    public ModelAndView release(Integer page){
        ModelAndView mv=new ModelAndView();
        if (page==null||"".equals(page)){
            page=1;
        }
        List<Resources> resourcesAll = resourceAdminService.resourcesAll((page-1)*25,1);
        mv.addObject("resourcesAll",resourcesAll);
        mv.addObject("page", page);
        mv.addObject("pageCount", resourceAdminService.resourcesCount(1));
        mv.setViewName("resource-release");
        return mv;
    }

    /**
     * 未通过页面
     * @return
     */
    @RequestMapping("failed")
    public ModelAndView failed(Integer page){
        ModelAndView mv=new ModelAndView();
        if (page==null||"".equals(page)){
            page=1;
        }
        List<Resources> resourcesAll = resourceAdminService.resourcesAll((page-1)*25,2);
        mv.addObject("failed",resourcesAll);
        mv.addObject("page", page);
        mv.addObject("pageCount", resourceAdminService.resourcesCount(2));
        mv.setViewName("resource-failed");
        return mv;
    }

    /**
     * 撤销资源
     * @param id
     * @return
     */
    @RequestMapping("remove")
    public @ResponseBody String remove(Long id){
       Integer val= resourcesService.deleteResources(id);
       if (val>0) {
           return "1";
       }else {
           return "2";
       }
    }

    /**
     * 进入审核界面
     * @param id
     * @return
     */
    @RequestMapping("update")
    public ModelAndView update(Long id){
        ModelAndView mv=new ModelAndView();
        Resources resources = resourcesService.queryResourcesById(id);
        mv.addObject("resources",resources);
        mv.setViewName("resource-update");
        return mv;
    }

    /**
     * 审核过程
     * @param check
     * @return
     */
    @RequestMapping("auditing")
    public String auditing(Long id,Integer check,String username){
        resourceAdminService.updateResourceCheck(id,check);
        if (check==1){
            User user = userService.findByName(username);
            PointRecord pointRecord=new PointRecord(8,new Date(),"资源上传",user );
            int record = userService.addPointRecord(pointRecord);
            if (record>0){
                user.setScores(user.getScores()+pointRecord.getIntegral());
                userService.userUpadeScore(user);
            }
        }
        return "forward:unaudited.action";
    }
}
