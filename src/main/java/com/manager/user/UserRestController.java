package com.manager.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manager.user.bo.UserBO;

@RequestMapping("/user")
@RestController
public class UserRestController {

  @Autowired
  private UserBO userBO;
  
  @RequestMapping("/is_duplicated_userId")
  public Map<String, Boolean> isDuplicatedUserId(
    @RequestParam("userId") String userId) {
      
      Map<String, Boolean> result = new HashMap<>();

      result.put("result", userBO.existUserByUserId(userId));

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
      }

      return result;
  }

  @PostMapping("/sign_in")
  public Map<String, Object> signIn(
    @RequestParam("userId") String userId,
    @RequestParam("password") String password) {

    int row = userBO

    return result;
  }
}
