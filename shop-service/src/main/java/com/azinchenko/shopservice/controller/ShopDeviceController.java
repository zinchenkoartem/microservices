package com.azinchenko.shopservice.controller;

import com.azinchenko.shopservice.client.DeviceServiceClient;
import com.azinchenko.shopservice.entity.FullDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop-service")
public class ShopDeviceController {

  @Autowired
  private DeviceServiceClient deviceServiceClient;

  @RequestMapping("/devices")
  public List<FullDevice> devices() {
    System.out.println("!!!!!!!!!shop-servise is called!!!!!!!!!");
    return deviceServiceClient.getAll();
  }

  @RequestMapping("/device/{id}")
  public FullDevice device(@PathVariable("id") Long id) {
    return deviceServiceClient.get(id);
  }
}
