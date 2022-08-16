package com.manager.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/product")
@Controller
public class ProductController {
  
  @RequestMapping("/create_view")
  public String productCreate(Model model) {

    model.addAttribute("title", "상품 추가");
    model.addAttribute("viewName", "product/Product_create");

    return "template/Layout";
  }

  @RequestMapping("/update_view")
  public String productUpdate(
    Model model,
    @RequestParam("productId") int productId) {
    
    model.addAttribute("title", "상품 수정");
    model.addAttribute("viewName", "product/Product_modify");

    return "template/Layout";
  }
}
