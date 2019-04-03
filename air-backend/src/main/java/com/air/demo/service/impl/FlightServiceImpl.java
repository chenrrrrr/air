package com.air.demo.service.impl;

import java.util.List;

import com.air.demo.bean.Flight;
import com.air.demo.dao.FlightMapper;
import com.air.demo.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FlightServiceImpl
 */
@Service
public class FlightServiceImpl implements FlightService {

  @Autowired
  private FlightMapper flightMapper;

  @Override
  public int addFlight(Flight flight) throws Exception {
    return flightMapper.addFlight(flight);
  }

  @Override
  public List<Flight> selectFlight() throws Exception {
    return flightMapper.selectFlight();
  }

  @Override
  public int delFlightById(Flight flight) throws Exception {
    return flightMapper.delFlightById(flight);
  }

  @Override
  public int updateFlight(Flight flight) throws Exception {
    return flightMapper.updateFlight(flight);
  }

}