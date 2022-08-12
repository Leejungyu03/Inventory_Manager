package com.manager.product;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manager.product.bo.ProductBO;

@RequestMapping("/product")
@RestController
public class ProductRestCcontroller {

  @Autowired
  private ProductBO productBO;
  
  @PostMapping("/create")
  public Map<String, Object> productCreate(
    @RequestParam("title") String title,
    @RequestParam("content") String content,
    @RequestParam("stock") int stock,
    @RequestParam("imgUrl") String imgUrl,
    HttpSession session) {
    
    int userId = (Integer)session.getAttribute("userId");
    int row = productBO.addProduct(userId, title, content, stock, imgUrl);

    Map<String, Object> result = new HashMap<>();
    if (row < 1) {
      
    }

    

    return result;
  }
}
