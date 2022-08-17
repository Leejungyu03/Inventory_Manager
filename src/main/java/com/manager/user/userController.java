package com.manager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.user.bo.UserBO;
import com.manager.user.model.User;

@RequestMapping("/user")
@Controller 
public class UserController {

    @Autowired
    private UserBO userBo;
	
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

    @RequestMapping("/manager_view")
    public String managerView(Model model) {

        List<User> userList = userBo.getUser();

        model.addAttribute("title", "관리자");
        model.addAttribute("viewName", "user/Manager");
        model.addAttribute("userList", userList);

        return "template/Layout";
    }
}