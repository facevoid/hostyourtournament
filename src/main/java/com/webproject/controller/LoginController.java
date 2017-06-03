package com.webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shaurav on 1/31/2017.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String showLogin(){
        System.out.println("gg from login");
        return "login";
    }
    @RequestMapping("/logout")
    public String showLogout(){
        return "login";
    }


}
