package com.example.deviceapi.controller;

import com.example.deviceapi.model.Device;
import com.example.deviceapi.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // Retrieve all devices
    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    // Retrieve a specific device by ID
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> device = deviceService.getDeviceById(id);
        if (device.isPresent()) {
            return ResponseEntity.ok(device.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add a new device
    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    // Predict the price of a device and update it
    @PostMapping("/predict/{deviceId}")
    public ResponseEntity<String> predictDevicePrice(@PathVariable Long deviceId) {
        Optional<Device> optionalDevice = deviceService.getDeviceById(deviceId);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            // Call the Python service to get the predicted price
            Integer predictedPrice = callPythonService(device);
            String output = "Predicted price range for device " + deviceId + ": " + predictedPrice;
            deviceService.updateDevicePrice(deviceId, predictedPrice);
            return ResponseEntity.ok(output);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private Integer callPythonService(Device device) {
        RestTemplate restTemplate = new RestTemplate();
        String pythonApiUrl = "http://localhost:5000/predict";

        // Create a map for the device data
        Map<String, Object> deviceData = new HashMap<>();
        deviceData.put("batteryPower", device.getBatteryPower());
        deviceData.put("blue", device.isBluetooth());
        deviceData.put("clockSpeed", device.getClockSpeed());
        deviceData.put("dualSim", device.isDualSim());
        deviceData.put("fc", device.getFrontCamera());
        deviceData.put("fourG", device.isFourG());
        deviceData.put("intMemory", device.getInternalMemory());
        deviceData.put("mDep", device.getMobileDepth());
        deviceData.put("mobileWt", device.getMobileWeight());
        deviceData.put("nCores", device.getNumberOfCores());
        deviceData.put("pc", device.getPrimaryCamera());
        deviceData.put("pxHeight", device.getPixelHeight());
        deviceData.put("pxWidth", device.getPixelWidth());
        deviceData.put("ram", device.getRam());
        deviceData.put("scH", device.getScreenHeight());
        deviceData.put("scW", device.getScreenWidth());
        deviceData.put("talkTime", device.getTalkTime());
        deviceData.put("threeG", device.isThreeG());
        deviceData.put("touchScreen", device.isTouchScreen());
        deviceData.put("wifi", device.isWifi());

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(deviceData);
        ResponseEntity<Integer> response = restTemplate.postForEntity(pythonApiUrl, request, Integer.class);
        System.out.println("Response from Flask: " + response.getBody());

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to get response from Python service");
            }
        }
}
