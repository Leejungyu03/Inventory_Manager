package com.manager.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@Controller
public class ProductController {
  
  @RequestMapping("/create")
  public String productCreate(Model model) {

    model.addAttribute("title", "상품 추가");
    model.addAttribute("viewName", "product/Product_create");

    return "template/Layout";
  }
}
