package com.azinchenko.deviceservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient("price-service")
public interface PriceServiceClient {

  @RequestMapping("/prices")
  Map<String,Double> getPrice();

}
