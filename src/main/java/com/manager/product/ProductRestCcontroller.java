package com.manager.product;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    @RequestParam(value="imageFile", required = false) MultipartFile imageFile,
    HttpServletRequest request) {
	  
	  HttpSession session = request.getSession();
	  Integer userId = (Integer)session.getAttribute("userId");
    String loginId = (String)session.getAttribute("loginId");
    String userName = (String)session.getAttribute("name");
    
    int row = productBO.addProduct(loginId, userId, userName, title, content, stock, imageFile);

    Map<String, Object> result = new HashMap<>();
    if (row < 1) {
      result.put("result", "error");
    } else {
      result.put("result", "success");
    }

    return result;
  }
}
