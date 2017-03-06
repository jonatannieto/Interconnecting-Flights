package com.lepsec.interconnectingflights.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonatannietoa on 06/03/2017.
 */
public class Schedule implements Serializable {
    private int month;
    private Map<Integer, List<Flight>> days;

    public Schedule(int month) {
        this.month = month;
        this.days = new HashMap<>();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Map<Integer, List<Flight>> getDays() {
        return days;
    }

    public void setDays(Map<Integer, List<Flight>> days) {
        this.days = days;
    }
}
