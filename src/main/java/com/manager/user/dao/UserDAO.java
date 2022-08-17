package com.manager.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.manager.user.model.User;

@Repository
public interface UserDAO {

  public boolean existUserByLoginId(String loginId);
  
  public int insertUser(
		  @Param("loginId") String loginId,
		  @Param("password") String password,
		  @Param("name") String name);

	public User selectUserByLoginIdAndPassword(
		@Param("loginId") String loginId,
		@Param("password") String password);

	public List<User> selectUser();

	public int deleteUser(int userId);
}