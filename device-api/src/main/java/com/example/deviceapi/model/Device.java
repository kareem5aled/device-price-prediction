package com.example.deviceapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int batteryPower;
    private int bluetooth; 
    private float clockSpeed;
    private int dualSim; 
    private int frontCamera;
    private int fourG; 
    private int internalMemory;
    private float mobileDepth;
    private float mobileWeight;
    private int numberOfCores;
    private int primaryCamera;
    private int pixelHeight;
    private int pixelWidth;
    private int ram;
    private int screenHeight;
    private int screenWidth;
    private int talkTime;
    private int threeG; 
    private int touchScreen; 
    private int wifi; 
    private Integer priceRange; // This will be filled after prediction

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int isBluetooth() { 
        return bluetooth;
    }

    public void setBluetooth(int bluetooth) { 
        this.bluetooth = bluetooth;
    }

    public float getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int isDualSim() { 
        return dualSim;
    }

    public void setDualSim(int dualSim) { 
        this.dualSim = dualSim;
    }

    public int getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(int frontCamera) {
        this.frontCamera = frontCamera;
    }

    public int isFourG() { 
        return fourG;
    }

    public void setFourG(int fourG) { 
        this.fourG = fourG;
    }

    public int getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(int internalMemory) {
        this.internalMemory = internalMemory;
    }

    public float getMobileDepth() {
        return mobileDepth;
    }

    public void setMobileDepth(float mobileDepth) {
        this.mobileDepth = mobileDepth;
    }

    public float getMobileWeight() {
        return mobileWeight;
    }

    public void setMobileWeight(float mobileWeight) {
        this.mobileWeight = mobileWeight;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public int getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(int primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public int getPixelHeight() {
        return pixelHeight;
    }

    public void setPixelHeight(int pixelHeight) {
        this.pixelHeight = pixelHeight;
    }

    public int getPixelWidth() {
        return pixelWidth;
    }

    public void setPixelWidth(int pixelWidth) {
        this.pixelWidth = pixelWidth;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int isThreeG() { 
        return threeG;
    }

    public void setThreeG(int threeG) { 
        this.threeG = threeG;
    }

    public int isTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(int touchScreen) { 
        this.touchScreen = touchScreen;
    }

    public int isWifi() { 
        return wifi;
    }

    public void setWifi(int wifi) { 
        this.wifi = wifi;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }
}
