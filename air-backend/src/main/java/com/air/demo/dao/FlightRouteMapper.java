package com.air.demo.dao;

import java.util.List;

import com.air.demo.bean.FlightRoute;

import org.apache.ibatis.annotations.Mapper;

/**
 * FlightRouteMapper
 */
@Mapper
public interface FlightRouteMapper {

  int addFlightRoute(FlightRoute flightRoute) throws Exception;

  List<FlightRoute> selectFlightRouteByFlightId(FlightRoute flightRoute) throws Exception;

  int delFlightRouteByFlightId(FlightRoute flightRoute) throws Exception;

}