package com.azinchenko.shopservice.client;

import com.azinchenko.shopservice.entity.FullDevice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("device-service")
//@Component
public interface DeviceServiceClient {

  @RequestMapping("/all")
  List<FullDevice> getAll();

  @RequestMapping("/device/{id}")
  FullDevice get(@PathVariable("id") Long id);
}
