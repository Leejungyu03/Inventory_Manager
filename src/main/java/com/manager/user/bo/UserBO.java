package com.manager.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.user.dao.UserDAO;

@Service
public class UserBO {

  @Autowired
  private UserDAO userDAO;

  public boolean existUserByUserId (String userId) {
    return userDAO.existUserByLoginId(userId);
  }

  public int addUser(String userId, String password, String name) {
	  return userDAO.insertUser(userId, password, name);
  }
}