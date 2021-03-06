package com.azinchenko.deviceservice.controller;

import com.azinchenko.deviceservice.client.PriceServiceClient;
import com.azinchenko.deviceservice.entity.Device;
import com.azinchenko.deviceservice.entity.FullDevice;
import com.azinchenko.deviceservice.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RefreshScope
@RequestMapping("/device-service")
public class DeviceController {

//  private static volatile boolean aBoolean= false;

  @Autowired
  private DeviceRepository repository;

  @Autowired
  private PriceServiceClient priceServiceClient;

  @Value("${custom.device.price.multiplier}")
  private Double multiplier;

  @RequestMapping("/all")
  public List<FullDevice> getAll() {

      System.out.println("++++++++device-service is called!!!!!!!!!");
      System.out.println("multiplier is: " + multiplier);
      Map<String, Double> prices = priceServiceClient.getPrice();
      List<Device> devices = repository.findAll();
      return devices.stream().map(device -> {
        String name = device.getName();
        prices.get(name);
        return new FullDevice(name, prices.get(name) * multiplier);
      }).collect(Collectors.toList());

//      throw new RuntimeException("New Exception for Hystrix");

  }

  @RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
  public FullDevice getDevice(@PathVariable Long id) {
    Device device = repository.findById(id).orElse(new Device("NONE"));
    Map<String, Double> prices = priceServiceClient.getPrice();
    return new FullDevice(device.getName(), prices.get(device.getName()));
  }

}
