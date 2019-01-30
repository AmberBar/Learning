package com.amber.controller;

import com.amber.data.po.User;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.PasswordAuthentication;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/add")
    public String add(Model model) {
        System.out.println("进入add");
        return "success";
    }

    @GetMapping("/login")
    public String login(User user, Model model) {
        Subject subject =  SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(usernamePasswordToken);
            return "success";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "username does not exist!");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "password wrong");
            return "login";
        }
    }

}
