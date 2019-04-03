package com.air.demo.controller;

import com.air.demo.service.AroundService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * AroundController
 */
@RestController
public class AroundController {

  @Autowired
  private AroundService aroundService;

}