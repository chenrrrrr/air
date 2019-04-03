package com.air.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Msg
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Msg {

  private int id;
  private String createtime;
  private String content;
  private int posterid;
}