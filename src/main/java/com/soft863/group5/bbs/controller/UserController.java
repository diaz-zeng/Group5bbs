package com.soft863.group5.bbs.controller;

import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.User;
import com.soft863.group5.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    /*
     *
     * ajax校验用户名是否重复
     * */
    @RequestMapping("/userName")
    public void userName(String name, HttpServletResponse response) throws IOException {
        Map map = userService.queryByName(name);
        response.setContentType("text/xml;charset=utf-8");
        response.getWriter().print(map.get("msg"));
    }


    @RequestMapping("/addUser")
    public String addUser(User user, MultipartFile photo) throws IOException {
        System.out.println(22);
        String oldname = photo.getOriginalFilename();
        System.out.println(111);
        String newname = new Date().getTime() + "-" + oldname;
        File file = new File("d:photo", newname);
        photo.transferTo(file);
        user.setPhone(newname);


        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/userLogin")
    public String userLogin(String name, String password, HttpServletRequest request) {
        String name1 = request.getParameter("name");
        String password1 = request.getParameter("password");
        System.out.println(name1);
        System.out.println(password1);

        return null;
    }


    @RequestMapping("/regist")
    public String indexToRegist() {
        return "regist";
    }


}
