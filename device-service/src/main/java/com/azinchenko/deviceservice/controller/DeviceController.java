package com.azinchenko.deviceservice.controller;

import com.azinchenko.deviceservice.client.PriceServiceClient;
import com.azinchenko.deviceservice.entity.Device;
import com.azinchenko.deviceservice.entity.FullDevice;
import com.azinchenko.deviceservice.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class DeviceController {

  @Autowired
  private DeviceRepository repository;

  @Autowired
  private PriceServiceClient priceServiceClient;

  @RequestMapping("/all")
  public List<FullDevice> getAll() {
    System.out.println("++++++++device-servise is called!!!!!!!!!");
    Map<String, Double> prices = priceServiceClient.getPrice();
    List<Device> devices = repository.findAll();
    return devices.stream().map(device -> {
      String name = device.getName();
      prices.get(name);
      return new FullDevice(name, prices.get(name));
    }).collect(Collectors.toList());
  }

  @RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
  public FullDevice getDevice(@PathVariable Long id) {
    Device device = repository.findById(id).orElse(new Device("NONE"));
    Map<String, Double> prices = priceServiceClient.getPrice();
    return new FullDevice(device.getName(), prices.get(device.getName()));
  }

}
