package com.azinchenko.priceservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/price-service")
public class PriceController {

  @RequestMapping("/prices")
  public Map<String,Double> prices() {
    Map<String,Double> map = new HashMap<>();
    map.put("Android", 9000.05);
    map.put("iPhone", 1000.05);
    map.put("MacBook", 1500.05);
    return map;
  }
}
