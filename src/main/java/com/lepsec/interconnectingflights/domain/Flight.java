package com.lepsec.interconnectingflights.domain;

import java.io.Serializable;

/**
 * Created by jonatannietoa on 06/03/2017.
 */
public class Flight implements Serializable {
    private String number;
    private String departureTime;
    private String arrivalTime;

    public Flight(String number, String departureTime, String arrivalTime) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
