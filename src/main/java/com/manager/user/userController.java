package com.manager.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class userController {
	
    @RequestMapping("/sign_in_view")
    public String sign_in_view(Model model) {  
        model.addAttribute("viewName", "user/Sign_in");
        return "template/Layout"; 
    }
}