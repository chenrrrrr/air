package com.air.demo.controller;

import java.util.List;

import com.air.demo.bean.User;
import com.air.demo.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * 注册
   * 
   * @param user
   * @return
   */
  @PostMapping("/register")
  @ResponseBody
  public JSONObject register(@RequestBody User user) {
    JSONObject j = new JSONObject();
    try {
      if (userService.register(user) == 1) {
        j.put("code", 0);
        j.put("msg", "注册成功");
      }
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

  /**
   * 登录
   * 
   * @param user
   * @return
   */
  @PostMapping("/login")
  @ResponseBody
  public JSONObject login(@RequestBody User user) {
    JSONObject j = new JSONObject();
    try {
      User u = userService.login(user);
      if (u != null) {
        j.put("code", 0);
        j.put("msg", "登录成功");
        j.put("data", u);
      } else {
        j.put("code", 1);
        j.put("msg", "用户名密码错误");
      }
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

  /**
   * 管理员查用户
   * 
   * @return
   */
  @PostMapping("/selectUser")
  @ResponseBody
  public JSONObject selectUser() {
    JSONObject j = new JSONObject();
    try {
      List<User> users = userService.selectUser();
      if (users.size() != 0) {
        j.put("code", 0);
        j.put("data", users);
      }
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

  /**
   * 删除用户
   * 
   * @param user
   * @return
   */
  @PostMapping("/delUserById")
  @ResponseBody
  public JSONObject delUserById(@RequestBody User user) {
    JSONObject j = new JSONObject();
    try {
      if (userService.delUserById(user) == 1) {
        j.put("code", 0);
        j.put("msg", "删除成功");
      }
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

  /**
   * 修改用户
   * @param user
   * @return
   */
  @PostMapping("/updateUser")
  @ResponseBody
  public JSONObject updateUser(@RequestBody User user) {
    JSONObject j = new JSONObject();
    try {
      if (userService.updateUser(user) == 1) {
        j.put("code", 0);
        j.put("msg", "修改成功");
      }
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

}