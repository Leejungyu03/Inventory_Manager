package com.manager.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.product.bo.ProductBO;
import com.manager.product.model.Product;

@RequestMapping("/product")
@Controller
public class ProductController {

  @Autowired
  private ProductBO productBO;
  
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

    Product product = productBO.getProductByProductId(productId);
    
    model.addAttribute("title", "상품 수정");
    model.addAttribute("product", product);
    model.addAttribute("viewName", "product/Product_modify");

    return "template/Layout";
  }
}
