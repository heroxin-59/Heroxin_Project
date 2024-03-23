package com.hero.controller;

import com.hero.pojo.User;
import com.hero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Heroxin
 * @create 2022-03-31-16:33
 * @Description:
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelAndView modelAndView;

//    验证用户登录
    @RequestMapping("/query")
    public String query(User user, HttpSession session){
        User query = userService.query(user);

        modelAndView.addObject("query",query);
        modelAndView.setViewName("login");

        if (query != null){
//            将用户放入 session
            session.setAttribute("user",query);
            return "redirect:/main.jsp";
        }
        return "redirect:/login.jsp";
    }

//    用户注册(添加用户)
    @RequestMapping("/insert")
    public String insert(User user){
        userService.insert(user);
        return "redirect:/login.jsp";
    }
}
