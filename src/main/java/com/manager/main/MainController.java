package com.manager.main;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.product.bo.ProductBO;
import com.manager.product.model.Product;

@Controller
public class MainController {

  @Autowired
  private ProductBO productBO;

  @RequestMapping("/main")
  public String Main(Model model, HttpSession session) {

    String loginId = (String)session.getAttribute("loginId");

    if (loginId == null) {
      return "redirect:/user/sign_in_view";
    }

    List<Product> product = productBO.getProduct();

    model.addAttribute("viewName", "main/Main");
    model.addAttribute("productList", product);

    return "template/Layout";
  }
}