package com.air.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * FlightRoute
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightRoute {

  private int id;
  private int flightid;
  private String height;
  private String jing;
  private String wei;
  private String city;
  private String weather;
  private String time; // 到达指定地点的时间

}