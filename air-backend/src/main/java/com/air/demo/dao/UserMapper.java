package com.air.demo.dao;

import java.util.List;

import com.air.demo.bean.User;

import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper {

  int register(User user) throws Exception;

  User login(User user) throws Exception;

  List<User> selectUser() throws Exception;

  int delUserById(User user) throws Exception;

  int updateUser(User user) throws Exception;

}