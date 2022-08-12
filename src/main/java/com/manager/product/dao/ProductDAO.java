package com.manager.product.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO {
	
	public int insertProduct(
		@Param("userId") int userId,
		@Param("title") String title,
		@Param("content") String content,
		@Param("stock") int stock,
		@Param("imgUrl") String imgUrl);
}