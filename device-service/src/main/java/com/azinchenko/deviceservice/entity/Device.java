package com.azinchenko.deviceservice.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Device {

  @Id
  @GeneratedValue
  private long id;
  private String name;

  public Device(String name) {
    this.name = name;
  }
}
