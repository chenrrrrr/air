package com.air.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Flight
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flight {

  private int id;
  private String ttime;
  private String no;
  private String company;
  private String planemodel;
  private String destination;
  private String plantime;
  private String tno;
  private String port;
  private String extra;
}