package com.air.demo.dao;

import java.util.List;

import com.air.demo.bean.Flight;

import org.apache.ibatis.annotations.Mapper;

/**
 * FlightMapper
 */
@Mapper
public interface FlightMapper {

  int addFlight(Flight flight) throws Exception;

  List<Flight> selectFlight() throws Exception;

  int delFlightById(Flight flight) throws Exception;

  int updateFlight(Flight flight) throws Exception;

}