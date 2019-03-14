package com.soft863.group5.bbs.controller;

import com.soft863.group5.bbs.service.AdminService;
import com.soft863.group5.bbs.service.ArticleService;
import com.soft863.group5.bbs.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author yangjixiang
 * @version 1.0
 * @date 2019/1/15 20:27
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    ArticleService articleService;

    @Autowired
    ResourcesService resourcesService;

    @RequestMapping("param")
    public ModelAndView getParam() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("background-home");
        modelAndView.addObject("resourcesCount", resourcesService.queryResourcesCount(0));
        modelAndView.addObject("articleCount", articleService.getCount(0));
        return modelAndView;
    }

    @RequestMapping("/login")
    public @ResponseBody
    String AdminLogin(String name, String password, HttpServletRequest request) {
        Map<String, Object> map = adminService.adminLogin(name, password);
        if ("success".equals((String) map.get("status"))) {
            request.getSession().setAttribute("admin", map.get("admin"));
            return "1";
        } else {
            return "2";
        }
    }

    @RequestMapping("/clear")
    public @ResponseBody
    String clear(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "1";
        } else {
            session.removeAttribute("admin");
            return "1";
        }
    }
}
