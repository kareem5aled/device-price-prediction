package com.example.deviceapi.controller;

import com.example.deviceapi.model.Device;
import com.example.deviceapi.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> device = deviceService.getDeviceById(id);
        if (device.isPresent()) {
            return ResponseEntity.ok(device.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @PostMapping("/predict/{deviceId}")
    public ResponseEntity<Device> predictDevicePrice(@PathVariable Long deviceId) {
        Optional<Device> optionalDevice = deviceService.getDeviceById(deviceId);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            // Call the Python service to get the predicted price
            Integer predictedPrice = callPythonService(device);
            device = deviceService.updateDevicePrice(deviceId, predictedPrice);
            return ResponseEntity.ok(device);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private Integer callPythonService(Device device) {
        String pythonServiceUrl = "https://5000-kareem5aled-deviceprice-05jnr5nna37.ws-eu111.gitpod.io/predict"; // Replace with your actual Python service URL

        ResponseEntity<Integer> response = restTemplate.postForEntity(pythonServiceUrl, device, Integer.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to get response from Python service");
        }
    }
}
