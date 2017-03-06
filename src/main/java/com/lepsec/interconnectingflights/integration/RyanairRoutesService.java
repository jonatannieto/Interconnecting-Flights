package com.lepsec.interconnectingflights.integration;

import com.lepsec.interconnectingflights.configuration.RyanairProperties;
import com.lepsec.interconnectingflights.domain.Route;
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
public class RyanairRoutesService {
    private static final Logger logger = LoggerFactory.getLogger(RyanairRoutesService.class);

    private final RestTemplate restTemplate;

    private final String RYANAIR_ROUTES_URL;

    private final List<Route> routeList;

    /**
     * Instantiates a new Ryanair flights service.
     *
     * @param restTemplate the rest template
     */
    @Autowired
    public RyanairRoutesService(RestTemplate restTemplate, RyanairProperties ryanairProperties){
        this.restTemplate = restTemplate;
        RYANAIR_ROUTES_URL = ryanairProperties.getApi().getRoutes();
        routeList = new ArrayList<>();
    }

    /**
     * Get route list from Ryanair API.
     *
     * @return the list of Ryanair Route
     */
    public List<Route> getRoutes(){
        logger.info("Requesting Route from Ryanair");
        URI url = new UriTemplate(RYANAIR_ROUTES_URL).expand();
        return invoke(url, routeList.getClass());
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
        return exchange.getBody();
    }
}
