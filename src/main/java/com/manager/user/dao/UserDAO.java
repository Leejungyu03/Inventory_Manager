package com.manager.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.manager.user.model.User;

@Repository
public interface UserDAO {

  public boolean existUserByLoginId(String userId);
  
  public int insertUser(
		  @Param("userId") String userId,
		  @Param("password") String password,
		  @Param("name") String name);

	public User selectUserByUserIdAndPassword(
		@Param("userId") String userID,
		@Param("password") String password);
}
