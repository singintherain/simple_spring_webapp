package com.lvsong.web;

import com.lvsong.domain.user.User;
import com.lvsong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lvsong on 12/20/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "user/register";
    }

    @RequestMapping(method= RequestMethod.POST)
    public ModelAndView createUser(User user) {

        userService.createUser(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/createSuccess");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
