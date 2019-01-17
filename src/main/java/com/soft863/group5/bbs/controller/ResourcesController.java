package com.soft863.group5.bbs.controller;

import com.soft863.group5.bbs.entity.Resources;
import com.soft863.group5.bbs.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author zhaosl
 * date 2019/1/16 14:30
 *
 * @version 1.0
 */
@Controller
@RequestMapping("resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    @RequestMapping("listResources")
    public ModelAndView listResources(){
        ModelAndView modelAndView = new ModelAndView();
        List<Resources> resources = resourcesService.queryAllResources();
//        model.addAttribute("resources",resources);
//        return "index";
        modelAndView.addObject("resources",resources);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("listResourcesByPage")
    public ModelAndView listResourcesByPage(Integer currentPage) {
        ModelAndView modelAndView = new ModelAndView();
        if (currentPage==null||"".equals(currentPage)){currentPage=1;}
        Integer total=resourcesService.queryResourcesCount();
        Pagination page=new Pagination(currentPage,8,total);
        Map<String,Object> map=new HashMap<>();
        map.put("position",page.getPosition()-1);
        map.put("size",page.getSize());
        List<Resources> resources = resourcesService.queryAllResourcesByPage(map);
        modelAndView.addObject("resources",resources);
        modelAndView.addObject("currentPage",page.getCurrentPage());
        modelAndView.addObject("totalPage",page.getTotalPage());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("saveResources")
    public ModelAndView saveResources(Resources resources){
        ModelAndView modelAndView=new ModelAndView();
        Resources resources1 = resourcesService.queryResourcesByName(resources.getName());
        if (resources1!=null){
            modelAndView.addObject("error","该资源已存在");
            modelAndView.setViewName("forward:upload.action");
        }else{
            Integer count = resourcesService.addResources(resources);
            boolean flag = count>0 ? true:false;
            if (flag=true){
                modelAndView.setViewName("forward:upload.action");
            }else{
                modelAndView.addObject("error","添加失败");
            }
        }
        modelAndView.setViewName("forward:upload.action");
        return modelAndView;
    }
    @RequestMapping("queryResourcesById")
    public ModelAndView queryResourcesById(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        String id = request.getParameter("id");
        if (id != null){
            Long id2=Long.parseLong(id);
            Resources resources = resourcesService.queryResourcesById(id2);
            modelAndView.addObject("resource",resources);
            modelAndView.setViewName("detai");
            return modelAndView;
        }else{
            modelAndView.addObject("error","该资源不存在");
            modelAndView.setViewName("forward:listResourcesByPage.action");
        }
        return modelAndView;
    }
}
