package com.soft863.group5.bbs.controller;

import com.soft863.group5.bbs.entity.Article;
import com.soft863.group5.bbs.entity.Pagination;
import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.User;
import com.soft863.group5.bbs.service.ArticleService;
import com.soft863.group5.bbs.service.ArticleServiceImpl;
import com.soft863.group5.bbs.service.CommentMangeService;
import com.soft863.group5.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评论 sl
 */

@Controller
@RequestMapping("/comment")
public class CommentManageController {

    @Autowired
    private CommentMangeService commentMangeService;

    @Autowired
    private UserService userService;

    @Autowired
    ArticleService articleService;

    /**
     * 积分展示
     *
     * @param page
     * @param name
     * @return
     */
    @RequestMapping("turnPage")
    public ModelAndView turnPage(Integer page, String name) {
        ModelAndView mv = new ModelAndView();
        List<PointRecord> pointRecords = commentMangeService.paging(name, page);
        mv.addObject("page", page);
        mv.addObject("records", commentMangeService.paging(name, page));
        mv.addObject("user", userService.findByName(name));
        mv.setViewName("integral-manage");
        return mv;
    }


    @RequestMapping("/integral")
    public ModelAndView all(String name) {
        ModelAndView mv = new ModelAndView();
        if (name != null && !name.equals("")) {
            User user = userService.findByName(name);

            mv.addObject("user", user);
            mv.setViewName("integral-manage");
        } else {
            mv.setViewName("integral-manage");
        }
        return mv;
    }

    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping("/all")
    public ModelAndView queryAll( Integer page) {
        if (page == null) {
            page = 1;
        }
       /* Integer num = commentMangeService.queryTotalNum();
        Pagination pagination = new Pagination(page, 5, num);
        Map<String, Object> map = new HashMap();
        map.put("pass", 0);
        map.put("start", pagination.getPosition());
        map.put("size", pagination.getSize());

        ModelAndView mv = new ModelAndView();

        List<Article> articles = commentMangeService.queryAll(map);
        mv.addObject("articles", articles);
        mv.addObject("totalPage", pagination.getTotalPage());
        mv.addObject("currentPage", pagination.getCurrentPage());
        mv.setViewName("comment-manage");
        return mv;*/
        ModelAndView modelAndView = new ModelAndView();

        List<Article> articles = articleService.showArticle((page - 1) * 25, 0);

        modelAndView.addObject("articles", articles);
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageCount", articleService.getCount(0));
        modelAndView.setViewName("comment-manage");
        return modelAndView;
    }


    @RequestMapping("/loser")
    public ModelAndView queryloser(Integer page) {
        if (page == null) {
            page = 1;
        }
//        Integer num = commentMangeService.queryTotalNum();
//        Pagination pagination=new Pagination(page,5,num);
//        Map<String,Object> map=new HashMap();
//        map.put("pass",0);
//        map.put("start",pagination.getPosition());
//        map.put("size",pagination.getSize());
//
//        ModelAndView mv = new ModelAndView();
//        List<Article> loser = commentMangeService.queryAll(map);
//        mv.addObject("loser", loser);
//        mv.addObject("totalPage",pagination.getTotalPage());
//        mv.addObject("currentPage",pagination.getCurrentPage());
//        mv.setViewName("comment-loser");
        ModelAndView modelAndView = new ModelAndView();

        List<Article> loser = articleService.showArticle((page - 1) * 25, -1);

        modelAndView.addObject("loser", loser);
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageCount", articleService.getCount(-1));
        modelAndView.setViewName("comment-loser");
        return modelAndView;
    }

    @RequestMapping("/pass")
    public ModelAndView querypass(Integer page) {
        if (page == null ) {
            page = 1;
        }
       /* Integer num = commentMangeService.queryTotalNum();
        Pagination pagination = new Pagination(page, 5, num);
        Map<String, Object> map = new HashMap();
        map.put("pass", 0);
        map.put("start", pagination.getPosition());
        map.put("size", pagination.getSize());

        ModelAndView mv = new ModelAndView();
        List<Article> pass = commentMangeService.queryAll(map);
        mv.addObject("pass", pass);
        mv.addObject("totalPage", pagination.getTotalPage());
        mv.addObject("currentPage", pagination.getCurrentPage());
        mv.setViewName("comment-pass");
        return mv;*/

        ModelAndView modelAndView = new ModelAndView();
        List<Article> pass = articleService.showArticle((page - 1) * 25, 1);
        modelAndView.addObject("pass", pass);
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageCount", articleService.getCount(1));
        modelAndView.setViewName("comment-pass");
        return modelAndView;
    }


    /**
     * 未通过
     *
     * @param id
     * @return
     */
    @RequestMapping("/losers")
    @ResponseBody
    public String loser(Integer p, Long id) {
        ModelAndView mv = new ModelAndView();
        boolean result = commentMangeService.updatecomment(-1, id);
        if (result) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 已经通过
     *
     * @param id
     * @return
     */
    @RequestMapping("/passs")
    @ResponseBody
    public String pass(Integer p, Long id) {
        ModelAndView mv = new ModelAndView();
        boolean result = commentMangeService.updatecomment(1, id);
        if (result) {
            return "success";
        } else {
            return "error";
        }

    }


}
