package com.azinchenko.shopservice.controller;

import com.azinchenko.shopservice.client.DeviceServiceClient;
import com.azinchenko.shopservice.entity.FullDevice;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop-service")
public class ShopDeviceController {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private DeviceServiceClient deviceServiceClient;

  @RequestMapping(value = "/devices", method = RequestMethod.GET)
  @HystrixCommand(fallbackMethod = "fallbackDefaultMethod")
  public List<FullDevice> devices() {
//    System.out.println("!!!!!!!!!shop-servise is called!!!!!!!!!");
    log.info(" logged massage: shop-servise is called {}", "!!!!!!!");
    return deviceServiceClient.getAll();
  }

  private List<FullDevice> fallbackDefaultMethod() {
    List<FullDevice> fullDevices = new ArrayList<>();
    fullDevices.add(new FullDevice(0.0d, "none"));
    return fullDevices;
  }

  @RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
  public FullDevice device(@PathVariable("id") Long id) {
    return deviceServiceClient.get(id);
  }
}
