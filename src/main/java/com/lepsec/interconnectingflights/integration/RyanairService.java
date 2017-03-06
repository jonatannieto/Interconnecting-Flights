package com.lepsec.interconnectingflights.integration;

import com.lepsec.interconnectingflights.configuration.RyanairProperties;
import com.lepsec.interconnectingflights.domain.Route;
import com.lepsec.interconnectingflights.domain.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonatannietoa on 06/03/2017.
 */
@Service
public class RyanairService {
    private static final Logger logger = LoggerFactory.getLogger(RyanairService.class);

    private final RestTemplate restTemplate;

    private final String RYANAIR_ROUTES_URL;

    private final String RYANAIR_SCHEDULE_URL;

    private final List<Route> routeList;

    /**
     * Instantiates a new Ryanair flights service.
     *
     * @param restTemplate the rest template
     */
    @Autowired
    public RyanairService(RestTemplate restTemplate, RyanairProperties ryanairProperties){
        this.restTemplate = restTemplate;
        RYANAIR_ROUTES_URL = ryanairProperties.getApi().getRoutes();
        RYANAIR_SCHEDULE_URL = ryanairProperties.getApi().getSchedule();
        routeList = new ArrayList<>();
    }

    /**
     * Get route list from Ryanair API.
     *
     * @return the list of Ryanair Route
     */
    public List<Route> getRoutes(){
        logger.info("Requesting Routes from Ryanair API");
        URI url = new UriTemplate(RYANAIR_ROUTES_URL).expand();
        return invoke(url, routeList.getClass());
    }

    /**
     * Get schedule list from Ryanair API.
     *
     * @return the list of Ryanair Schedule
     */
    public Schedule getSchedule(String departue, String arrival, int year, int month){
        logger.info("Requesting Schedule from Ryanair API for {} to {} in the month {} of {}", departue, arrival, month, year);
        URI url = new UriTemplate(RYANAIR_SCHEDULE_URL).expand(departue, arrival, year, month);
        return invoke(url, Schedule.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
        return exchange.getBody();
    }
}
