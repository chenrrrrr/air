package com.air.demo.service;

import java.util.List;

import com.air.demo.bean.FlightRoute;

/**
 * FlightRouteService
 */
public interface FlightRouteService {

  int addFlightRoute(FlightRoute flightRoute) throws Exception;

  List<FlightRoute> selectFlightRouteByFlightId(FlightRoute flightRoute) throws Exception;

  int delFlightRouteByFlightId(FlightRoute flightRoute) throws Exception;

}