package com.air.demo.service;

import java.util.List;

import com.air.demo.bean.User;

/**
 * UserService
 */
public interface UserService {

  int register(User user) throws Exception;

  User login(User user) throws Exception;

  List<User> selectUser() throws Exception;

  int delUserById(User user) throws Exception;

  int updateUser(User user) throws Exception;

}