package com.air.demo.service.impl;

import com.air.demo.dao.MsgMapper;
import com.air.demo.service.MsgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MsgServiceImpl
 */
@Service
public class MsgServiceImpl implements MsgService {

  @Autowired
  private MsgMapper msgMapper;
}