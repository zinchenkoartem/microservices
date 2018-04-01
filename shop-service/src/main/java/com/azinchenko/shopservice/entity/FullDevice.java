package com.azinchenko.shopservice.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FullDevice {

  private Double price;
  private String name;

  public FullDevice(Double price, String name) {
    this.price = price;
    this.name = name;
  }

}
