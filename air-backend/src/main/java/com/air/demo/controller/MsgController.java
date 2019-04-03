package com.air.demo.controller;

import com.air.demo.service.MsgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * MsgController
 */
@RestController
public class MsgController {

  @Autowired
  private MsgService msgService;

}