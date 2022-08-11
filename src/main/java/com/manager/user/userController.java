package com.manager.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller 
public class UserController {
	
    @RequestMapping("/sign_in_view")
    public String signInView(Model model) {  
        model.addAttribute("title", "로그인");
        model.addAttribute("viewName", "user/Sign_in");
        return "template/Layout"; 
    }

    @RequestMapping("/sign_up_view")
    public String signUpView(Model model) {
        model.addAttribute("title", "회원가입");
        model.addAttribute("viewName", "user/Sign_up");
        return "template/Layout";
    }
}