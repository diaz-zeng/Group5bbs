package com.soft863.group5.bbs.controller;

import com.soft863.group5.bbs.entity.Article;
import com.soft863.group5.bbs.service.CommentMangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 评论 sl
 */

@Controller
@RequestMapping("/comment")
public class CommentManageController {

    @Autowired
    private CommentMangeService commentMangeService;


    /**
     * 查询全部
     * @param model
     * @return
     */
    @RequestMapping("/query")
    public ModelAndView queryAll(Model model){
        ModelAndView mv=new ModelAndView();
        List<Article> articles=commentMangeService.queryAll();
        mv.addObject("articles",articles);
        mv.setViewName("comment-manage");
        return mv;
    }

    /**
     * 未通过
     * @param id
     * @return
     */
    @RequestMapping("loser")
    public ModelAndView loser(Integer p,Long id){
        ModelAndView mv=new ModelAndView();
        if("b".equals(true)){
            mv.setViewName("comment-pass");
        }else {
            System.out.println("error--------------");
        }
        return mv;
    }

    /**
     * 已经通过
     * @param id
     * @return
     */
    @RequestMapping("pass")
    public ModelAndView pass(Integer p,Long id){
        ModelAndView mv=new ModelAndView();
        boolean b = commentMangeService.updatecomment(p, id);
        if("b".equals(true)){
            mv.setViewName("comment-pass");
        }else {
            System.out.println("error--------------");
        }
        return mv;
    }

}
