package com.example.deviceapi.repository;

import com.example.deviceapi.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    // JpaRepository provides CRUD operations and more
}
