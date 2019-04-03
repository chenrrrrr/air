package com.air.demo.service.impl;

import com.air.demo.dao.OrderMapper;
import com.air.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl
 */
@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderMapper orderMapper;

}