package com.azinchenko.deviceservice.repository;

import com.azinchenko.deviceservice.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource
public interface DeviceRepository extends JpaRepository<Device, Long> {

  Device findDeviceByName(String name);
}
