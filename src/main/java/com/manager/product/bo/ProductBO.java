package com.manager.product.bo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manager.config.FileManagerService;
import com.manager.product.dao.ProductDAO;
import com.manager.product.model.Product;


@Service
public class ProductBO {
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ProductDAO productDAO; 

  @Autowired
  private FileManagerService fileManagerService;

  public int addProduct(String loginId, Integer userId, String userName, String title, String content, int stock, MultipartFile imageFile) {
		
    String imagePath = null;
		if (imageFile != null) {
			try {
				imagePath = fileManagerService.saveFile(loginId, imageFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

    return productDAO.insertProduct(userId, userName, title, content, stock, imagePath);
  }

  public List<Product> getProduct() {
    return productDAO.selectProduct();
  }
}
