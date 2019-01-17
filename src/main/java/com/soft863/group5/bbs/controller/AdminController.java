package com.soft863.group5.bbs.controller;

import com.soft863.group5.bbs.service.AdminService;
import javafx.scene.layout.Background;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("param")
    public String getParam(){
        return "background-home";
    }

    @RequestMapping("/login")
    public String AdminLogin(Integer id, String password, HttpServletRequest request){
        Map<String, Object> map = adminService.adminLogin(id, password);
        if ("success".equals((String) map.get("status"))){
            request.getSession().setAttribute("admin",map.get("admin"));
            return "background-home";
        }
        return "index";
    }
}
