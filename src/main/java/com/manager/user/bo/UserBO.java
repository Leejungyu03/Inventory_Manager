package com.manager.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.user.dao.UserDAO;
import com.manager.user.model.User;

@Service
public class UserBO {

  @Autowired
  private UserDAO userDAO;

  public boolean existUserByLoginId (String loginId) {
    return userDAO.existUserByLoginId(loginId);
  }

  public int addUser(String loginId, String password, String name) {
	  return userDAO.insertUser(loginId, password, name);
  }

  public User getUserByLoginIdAndPassword(String loginId, String password) {
    return userDAO.selectUserByLoginIdAndPassword(loginId, password);
  }
}