package com.lepsec.interconnectingflights.domain;

import java.io.Serializable;

/**
 * Created by jonatannietoa on 06/03/2017.
 */
public class Route implements Serializable {
    private String airportFrom;
    private String airportTo;
    private String connectingAirport;
    private Boolean newRoute;
    private Boolean seasonalRoute;

    public Route(String airportFrom, String airportTo, String connectingAirport, Boolean newRoute, Boolean seasonalRoute) {
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.connectingAirport = connectingAirport;
        this.newRoute = newRoute;
        this.seasonalRoute = seasonalRoute;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public String getConnectingAirport() {
        return connectingAirport;
    }

    public void setConnectingAirport(String connectingAirport) {
        this.connectingAirport = connectingAirport;
    }

    public Boolean getNewRoute() {
        return newRoute;
    }

    public void setNewRoute(Boolean newRoute) {
        this.newRoute = newRoute;
    }

    public Boolean getSeasonalRoute() {
        return seasonalRoute;
    }

    public void setSeasonalRoute(Boolean seasonalRoute) {
        this.seasonalRoute = seasonalRoute;
    }
}
