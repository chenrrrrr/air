package com.air.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Order
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

  private int id;
  private String name;
  private String createtime;
  private int buyerid;
  private int flightid; // 航班id
}