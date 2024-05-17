package com.example.deviceapi.service;

import com.example.deviceapi.model.Device;
import com.example.deviceapi.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device updateDevicePrice(Long id, Integer priceRange) {
        Optional<Device> optionalDevice = deviceRepository.findById(id);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            device.setPriceRange(priceRange);
            return deviceRepository.save(device);
        }
        return null;
    }
}
