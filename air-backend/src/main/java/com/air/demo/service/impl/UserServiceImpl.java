package com.air.demo.service.impl;

import java.util.List;

import com.air.demo.bean.User;
import com.air.demo.dao.UserMapper;
import com.air.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public int register(User user) throws Exception {
    return userMapper.register(user);
  }

  @Override
  public User login(User user) throws Exception {
    return userMapper.login(user);
  }

  @Override
  public List<User> selectUser() throws Exception {
    return userMapper.selectUser();
  }

  @Override
  public int delUserById(User user) throws Exception {
    return userMapper.delUserById(user);
  }

  @Override
  public int updateUser(User user) throws Exception {
    return userMapper.updateUser(user);
  }

}