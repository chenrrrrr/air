package com.air.demo.service.impl;

import java.util.List;

import com.air.demo.bean.FlightRoute;
import com.air.demo.dao.FlightRouteMapper;
import com.air.demo.service.FlightRouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FlightRouteServiceImpl
 */
@Service
public class FlightRouteServiceImpl implements FlightRouteService {

  @Autowired
  private FlightRouteMapper flightRouteMapper;

  @Override
  public int addFlightRoute(FlightRoute flightRoute) throws Exception {
    return flightRouteMapper.addFlightRoute(flightRoute);
  }

  @Override
  public List<FlightRoute> selectFlightRouteByFlightId(FlightRoute flightRoute) throws Exception {
    return flightRouteMapper.selectFlightRouteByFlightId(flightRoute);
  }

  @Override
  public int delFlightRouteByFlightId(FlightRoute flightRoute) throws Exception {
    return flightRouteMapper.delFlightRouteByFlightId(flightRoute);
  }

}