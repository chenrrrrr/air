package com.air.demo.controller;

import java.util.List;

import com.air.demo.bean.Flight;
import com.air.demo.service.FlightService;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * FlightController
 */
@RestController
public class FlightController {

  @Autowired
  private FlightService flightService;

  /**
   * 添加航班
   * 
   * @param flight
   * @return
   */
  @PostMapping("/addFlight")
  @ResponseBody
  public JSONObject addFlight(@RequestBody Flight flight) {
    JSONObject j = new JSONObject();
    try {
      if (flightService.addFlight(flight) == 1) {
        j.put("code", 0);
        j.put("msg", "增加航班成功");
      }
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

  /**
   * 管理员查航班
   * 
   * @return
   */
  @PostMapping("/selectFlight")
  @ResponseBody
  public JSONObject selectFlight() {
    JSONObject j = new JSONObject();
    try {
      List<Flight> flights = flightService.selectFlight();
      if (flights.size() != 0) {
        j.put("code", 0);
        j.put("data", flights);
      }
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

  /**
   * 删除航班
   * 
   * @param user
   * @return
   */
  @PostMapping("/delFlightById")
  @ResponseBody
  public JSONObject delFlightById(@RequestBody Flight flight) {
    JSONObject j = new JSONObject();
    try {
      if (flightService.delFlightById(flight) == 1) {
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
   * 修改航班
   * 
   * @param user
   * @return
   */
  @PostMapping("/updateFlight")
  @ResponseBody
  public JSONObject updateUser(@RequestBody Flight flight) {
    JSONObject j = new JSONObject();
    try {
      if (flightService.updateFlight(flight) == 1) {
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