package com.manager.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.manager.product.model.Product;

@Repository
public interface ProductDAO {
	
	public int insertProduct(
		@Param("userId") Integer userId,
		@Param("userName") String userName,
		@Param("title") String title,
		@Param("content") String content,
		@Param("stock") int stock,
		@Param("imagePath") String imageUrl);

	public List<Product> selectProduct();
}