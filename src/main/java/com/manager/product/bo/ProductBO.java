package com.manager.product.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.product.dao.ProductDAO;

@Service
public class ProductBO {

  @Autowired
  private ProductDAO productDAO;

  public int addProduct(int userId, String title, String content, int stock, String imgUrl) {
    return productDAO.insertProduct(userId, title, content, stock, imgUrl);
  }
}
