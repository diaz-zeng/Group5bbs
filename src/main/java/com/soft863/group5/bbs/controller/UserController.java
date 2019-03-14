package com.soft863.group5.bbs.controller;

import com.soft863.group5.bbs.entity.*;
import com.soft863.group5.bbs.exception.LoaclException;
import com.soft863.group5.bbs.service.ResourcesService;
import com.soft863.group5.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/User")
@SessionAttributes({"u"})
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ResourcesService resourcesService;

    /**
     * ajax校验用户名是否存在
     */
    @RequestMapping("/userName")
    public void userName(String name, HttpServletResponse response) throws IOException {
        Map map = userService.queryByName(name);
        response.setContentType("text/xml;charset=utf-8");
        response.getWriter().print(map.get("msg"));
    }

    /**
     * 添加用户
     *
     * @param user
     * @param date
     * @param pho
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/addUser")
    public ModelAndView addUser(User user, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, MultipartFile pho, Model model) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        user.setBirth(date);
        String oldname = pho.getOriginalFilename();
        String newname = new Date().getTime() + "-" + oldname;
        File file = new File("d:/photo", newname);
        pho.transferTo(file);
        user.setPhoto(newname);
        Map<String, Object> map = userService.addUser(user);
        modelAndView.addObject("msg", map.get("map"));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 主页面
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 用户登陆
     *
     * @param name
     * @param password
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/userLogin")
    public String userLogin(String name, String password, Model model, HttpServletRequest request) {
        User user = userService.findByName(name);
        HttpSession session = request.getSession();
        HashSet<Object> objects;
        if (user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute("u", user);
                session.setAttribute("flag", true);
                return "forward:/resources/listResourcesByPage.action";
            } else {
                session.setAttribute("user", false);
                return "index";
            }
        } else {
            session.setAttribute("flag", false);
            return "index";
        }
    }

    /**
     * 注册界面
     *
     * @return
     */
    @RequestMapping("/regist")
    public String indexToRegist() {
        return "regist";
    }

    /**
     * 个人资料
     *
     * @return
     */
    @RequestMapping("/personal")
    public String persinal() {
        return "personal";
    }

    /**
     * 退出登陆
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String clean(HttpSession session) {
        session.invalidate();
        return "index";
    }

    /**
     * 个人积分展示
     */
    @RequestMapping("/point{page}")
    public ModelAndView point(HttpSession session, @PathVariable("page") Integer currentPage) throws LoaclException {
        User user = (User) session.getAttribute("u");
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView();
            if (currentPage == null || "".equals(currentPage)) {
                currentPage = 1;
            }
            Integer total = userService.queryUserSocreNum(user.getId());
            Pagination pagination = new Pagination(currentPage, 5, total);
            Map<String, Object> map = new HashMap();
            map.put("position", pagination.getPosition());
            map.put("size", pagination.getSize());
            map.put("user", user);
            List<PointRecord> records = userService.queryUserScoreAll(map);
            modelAndView.addObject("currentPage", pagination.getCurrentPage());
            modelAndView.addObject("totalPage", pagination.getTotalPage());
            modelAndView.addObject("records", records);
            modelAndView.setViewName("point");
            return modelAndView;
        } else {
            throw new LoaclException("您尚未登录");
        }
    }


    /**
     * 密码找回页面跳转
     */
    @RequestMapping("/findpassword")
    public String findpassword() {
        return "findpassword";
    }

    /**
     * 密码找回
     *
     * @param way
     * @param username
     * @param pe
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/password")
    public String password(String way, String username, String pe, String password, Model model) {
        User user = userService.findByName(username);
        if (user != null) {
            if (way.equals("电话")) {
                Map<String, Object> map = userService.updatePassword(password, username);
                model.addAttribute("userpassword", "t");
            } else if (way.equals("邮箱")) {
                Map<String, Object> map = userService.updatePassword(password, username);
                model.addAttribute("userpassword", "t");
            } else {
                model.addAttribute("userpassword", "f");
            }
        } else {
            model.addAttribute("userpassword", "f");
        }
        return "index";
    }

    /**
     * 添加收藏，提示
     *
     * @param userid
     * @param reaourceid
     * @param response
     * @param model
     * @throws Exception
     */
    @RequestMapping("/shoucang")
    public void shoucang(String userid, String reaourceid, HttpServletResponse response, Model model) throws Exception {
        Long uid = Long.parseLong(userid);
        Long rid = Long.parseLong(reaourceid);
        User user = userService.queryById(uid);
        System.out.println(user);
        Resources resources = resourcesService.queryResourcesById(rid);
        boolean b = userService.addFavorute(new Favorite(user, resources, new Date()));
        System.out.println(b);
        if (b == true) {
            response.getWriter().print(1);
        } else {
            response.getWriter().print(0);

        }
    }

    /**
     * 访问收藏页面
     *
     * @return
     */
//    @RequestMapping("/favorite")
    public ModelAndView sc(HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("u");
        if (user != null) {
            modelAndView.addObject("favorites", userService.queryFavoriteByUserId(user.getId()));
            modelAndView.setViewName("shoucang");
            return modelAndView;
        } else {
            throw new LoaclException("您尚未登录");
        }
    }

    /**
     *
     * 分页
     */
    @RequestMapping("/favorite")
    public ModelAndView queryFavoriteAll(HttpSession session ,Integer currentPage) throws LoaclException {
        ModelAndView modelAndView = new ModelAndView();
        if (currentPage==null||" ".equals(currentPage)){
            currentPage=1;
        }
        User u = (User) session.getAttribute("u");
        if (u!=null){
        Integer totalPage=null;
        Integer total = userService.queryFavoriteCount(u.getId());
        if (total%5!=0){
            totalPage=total/8+1;
        }else {
            totalPage=total/8+0;
        }
        List<Favorite> favorites = userService.queryFavoriteAll(u.getId(),(currentPage-1)*5);
        modelAndView.addObject("favorites",favorites);
        modelAndView.addObject("currentPage",currentPage);
        modelAndView.addObject("totalPage",totalPage);
        modelAndView.setViewName("shoucang");
        return  modelAndView;
        }else {
            throw new LoaclException("您尚未登录");
        }
    }

}
