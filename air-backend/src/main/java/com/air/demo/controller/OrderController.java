package com.air.demo.controller;

import com.air.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 */
@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;
}