package com.azinchenko.shopservice.client;

import com.azinchenko.shopservice.entity.FullDevice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "device-service")
public interface DeviceServiceClient {

  @RequestMapping("/device-service/all")
  List<FullDevice> getAll();

  @RequestMapping("/device-service/device/{id}")
  FullDevice get(@PathVariable("id") Long id);
}
