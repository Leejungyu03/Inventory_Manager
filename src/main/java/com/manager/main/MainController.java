package com.manager.main;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping("/main")
  public String Main(
    Model model,
    HttpSession session) {
    model.addAttribute("viewName", "main/Main");
    String loginId = (String)session.getAttribute("loginId");

    if (loginId == null) {
      return "redirect:/user/sign_in_view";
    }

    return "template/Layout";
  }
}