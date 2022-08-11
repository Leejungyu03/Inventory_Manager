package com.manager.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manager.user.bo.UserBO;
import com.manager.user.model.User;

@RequestMapping("/user")
@RestController
public class UserRestController {

  @Autowired
  private UserBO userBO;
  
  @RequestMapping("/is_duplicated_userId")
  public Map<String, Object> isDuplicatedUserId(
    @RequestParam("userId") String userId) {
      
      Map<String, Object> result = new HashMap<>();
      
      boolean isDuplicatd = userBO.existUserByUserId(userId);
      if (isDuplicatd) {
    	  result.put("result", "success");
      } else {
    	  result.put("result", "false");
    	  result.put("error_message", "아이디 중복확인에 실패했습니다.");
      }

      return result;
  }

  @PostMapping("/sign_up")
  public Map<String, Object> signUp(
    @RequestParam("userId") String userId,
    @RequestParam("password") String password,
    @RequestParam("name") String name) {

      int row = userBO.addUser(userId, password, name);
      
      Map<String, Object> result = new HashMap<>();
      if (row < 1) {
    	  result.put("result", "error");
      } else {
    	  result.put("result", "success");
      }

      return result;
  }

  @PostMapping("/sign_in")
  public Map<String, Object> signIn(
    @RequestParam("userId") String userId,
    @RequestParam("password") String password,
    HttpSession session) {

    User user = userBO.getUserByUserIdAndPassword(userId, password);
    
    Map<String, Object> result = new HashMap<>();
    if (user != null) {
    	result.put("result", "success");
    	result.put("name", user.getName());
    	
    	session.setAttribute("userId", user.getUserId());
    	session.setAttribute("password", user.getPassword());
    	session.setAttribute("name", user.getName());
    } else {
    	result.put("result", "error");
    	result.put("error_message", "잘못된 아이디 또는  패스워드입니다.");
    }
    
    return result;
  }
}
