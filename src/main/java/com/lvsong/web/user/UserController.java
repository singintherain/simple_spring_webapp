package com.lvsong.web.user;

import com.lvsong.domain.user.User;
import com.lvsong.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lvsong on 12/20/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static String SESSIOIN_KEY = "self";

    @Autowired
    UserService userService;

    @Autowired
    ServletContext context;

    @RequestMapping("/register")
    public String register(HttpServletRequest httpServletRequest, HttpSession httpSession, HttpServletResponse httpServletResponse) {
        httpSession.setAttribute(SESSIOIN_KEY, "test");
        httpServletResponse.addCookie(new Cookie("myCookie", "asdfasfd"));
        httpServletResponse.addCookie(new Cookie("threadId", "" + Thread.currentThread().getId()));
        httpServletResponse.addCookie(new Cookie("userServiceId", "" + userService));
        httpServletResponse.addCookie(new Cookie("servletContext", "" + context));
        httpServletResponse.addCookie(new Cookie("servletContext2", "" + httpServletRequest.getServletContext()));
        return "user/register";
    }

    @RequestMapping("/session")
    public ModelAndView session(HttpSession httpSession) {
        httpSession.setAttribute("self", "test");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/session");
        modelAndView.addObject("session", httpSession.getAttribute(SESSIOIN_KEY));

        return modelAndView;
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
