package com.lvsong.web.student;

import com.lvsong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lvsong on 2/13/16.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private static String SESSIOIN_KEY = "student";

    @Autowired
    UserService userService;

    @Autowired
    ServletContext context;

    @RequestMapping("/register")
    public String register(HttpServletRequest httpServletRequest, HttpSession httpSession, HttpServletResponse httpServletResponse) {
        httpSession.setAttribute(SESSIOIN_KEY, "test");
        httpServletResponse.addCookie(new Cookie("studentMyCookie", "asdfasfd"));
        httpServletResponse.addCookie(new Cookie("studentThreadId", "" + Thread.currentThread().getId()));
        httpServletResponse.addCookie(new Cookie("studentUserServiceId", "" + userService));
        httpServletResponse.addCookie(new Cookie("studentUervletContext", "" + context));
        httpServletResponse.addCookie(new Cookie("studentUervletContext2", "" + httpServletRequest.getServletContext()));
        return "student/register";
    }
}
