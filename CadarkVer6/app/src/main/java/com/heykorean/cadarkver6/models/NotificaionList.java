package com.heykorean.cadarkver6.models;

/**
 * Created by Hey.Hung on 3/3/2016.
 */
public class NotificaionList {
    private String urlCar;
    private String nameCar;
    private String timeNoticeCar;

    public NotificaionList(String urlCar, String nameCar, String timeNoticeCar) {
        this.urlCar = urlCar;
        this.nameCar = nameCar;
        this.timeNoticeCar = timeNoticeCar;
    }

    public String getUrlCar() {
        return urlCar;
    }

    public void setUrlCar(String urlCar) {
        this.urlCar = urlCar;
    }

    public String getTimeNoticeCar() {
        return timeNoticeCar;
    }

    public void setTimeNoticeCar(String timeNoticeCar) {
        this.timeNoticeCar = timeNoticeCar;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }
}
