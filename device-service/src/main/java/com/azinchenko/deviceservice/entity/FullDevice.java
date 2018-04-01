package com.azinchenko.deviceservice.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class FullDevice {

  private Double price;
  private String name;

  public FullDevice(String name, Double price) {
    this.price = price;
    this.name = name;
  }

}
