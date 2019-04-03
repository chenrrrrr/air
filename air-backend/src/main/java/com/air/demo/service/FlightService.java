package com.air.demo.service;

import java.util.List;

import com.air.demo.bean.Flight;

/**
 * FlightService
 */
public interface FlightService {

  int addFlight(Flight flight) throws Exception;

  List<Flight> selectFlight() throws Exception;

  int delFlightById(Flight flight) throws Exception;

  int updateFlight(Flight flight) throws Exception;

}