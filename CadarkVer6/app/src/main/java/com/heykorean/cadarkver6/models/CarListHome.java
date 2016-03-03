package com.heykorean.cadarkver6.models;

/**
 * Created by SonNV1368 on 10/22/15.
 */
public class CarListHome {
    private int id;
    private String nameCar,timeRemain,urlCar,years,mileage,area;

    public CarListHome(int id, String nameCar, String timeRemain, String urlCar, String years, String mileage, String area) {
        this.id = id;
        this.nameCar = nameCar;
        this.timeRemain = timeRemain;
        this.urlCar = urlCar;
        this.years = years;
        this.mileage = mileage;
        this.area = area;
    }

    public CarListHome() {
    }

    public int getId() {
        return id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public String getTimeRemain() {
        return timeRemain;
    }

    public String getUrlCar() {
        return urlCar;
    }

    public String getYears() {
        return years;
    }

    public String getMileage() {
        return mileage;
    }

    public String getArea() {
        return area;
    }
}
