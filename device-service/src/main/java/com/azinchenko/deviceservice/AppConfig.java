package com.azinchenko.deviceservice;

import com.azinchenko.deviceservice.entity.Device;
import com.azinchenko.deviceservice.repository.DeviceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class AppConfig {
  @Bean
  CommandLineRunner runner(DeviceRepository repository) {
    return string -> {
      Stream.of(
              new Device("iPhone"),
              new Device("Android"),
              new Device("MacBook")
              )
              .forEach(repository::save);
      repository.findAll().forEach(System.out::println);
    };
  }
}
