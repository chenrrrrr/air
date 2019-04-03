package com.air.demo.controller;

import java.util.List;

import com.air.demo.bean.FlightRoute;
import com.air.demo.service.FlightRouteService;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * FlightRouteController
 */
@RestController
public class FlightRouteController {

  @Autowired
  private FlightRouteService flightRouteService;

  /**
   * 添加飞行路径
   */
  @PostMapping("/addFlightRoute")
  @ResponseBody
  public JSONObject addFlightRoute(@RequestBody FlightRoute flightRoute) {
    JSONObject j = new JSONObject();
    try {
      if (flightRouteService.addFlightRoute(flightRoute) == 1) {
        j.put("code", 0);
        j.put("msg", "添加飞行路径成功");
      }
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

  /**
   * 根据航班id查询飞行路径
   * 
   * @param flightRoute
   * @return
   */
  @PostMapping("/selectFlightRouteByFlightId")
  @ResponseBody
  public JSONObject selectFlightRouteByFlightId(@RequestBody FlightRoute flightRoute) {
    JSONObject j = new JSONObject();
    try {
      List<FlightRoute> f = flightRouteService.selectFlightRouteByFlightId(flightRoute);
      j.put("code", 0);
      j.put("data", f);
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

  /**
   * 根据id删除飞行路径
   * 
   * @param flightRoute
   * @return
   */
  @PostMapping("/delFlightRouteByFlightId")
  @ResponseBody
  public JSONObject delFlightRouteByFlightId(@RequestBody FlightRoute flightRoute) {
    JSONObject j = new JSONObject();
    try {
      if (flightRouteService.delFlightRouteByFlightId(flightRoute) == 1) {
        j.put("code", 0);
        j.put("msg", "删除飞行路径成功");
      }
    } catch (Exception e) {
      e.printStackTrace();
      j.put("code", -9);
      j.put("msg", e.getMessage());
    }
    return j;
  }

}