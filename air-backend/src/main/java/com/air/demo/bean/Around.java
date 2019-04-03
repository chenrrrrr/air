package com.air.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Around
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Around {

  private int id;
  private int type; // 0-经典 1-美食
  private String content;
}