package com.azinchenko.deviceservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "price-service")
public interface PriceServiceClient {

  @RequestMapping("/price-service/prices")
  Map<String,Double> getPrice();

}
