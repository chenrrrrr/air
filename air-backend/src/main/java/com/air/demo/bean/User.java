package com.air.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  private int id;
  private String username;
  private String password;
  private String phone;
  private String name;
  private String idcard;
  private int role; // 0-用户 1-管理员
}