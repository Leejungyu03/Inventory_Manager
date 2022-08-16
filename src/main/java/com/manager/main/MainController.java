package com.manager.main;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.product.bo.ProductBO;
import com.manager.product.model.Product;

@RequestMapping("/manager")
@Controller
public class MainController {

  @Autowired
  private ProductBO productBO;

  @RequestMapping("/main_view")
  public String Main(Model model, HttpSession session) {

    String loginId = (String)session.getAttribute("loginId");
    Integer userId = (Integer)session.getAttribute("userId");

    if (loginId == null) {
      return "redirect:/user/sign_in_view";
    }

    List<Product> productList = productBO.getProduct();

    model.addAttribute("title", "상품 재고 관리");
    model.addAttribute("viewName", "main/Main");
    model.addAttribute("productList", productList);
    model.addAttribute("userId", userId);

    return "template/Layout";
  }
}