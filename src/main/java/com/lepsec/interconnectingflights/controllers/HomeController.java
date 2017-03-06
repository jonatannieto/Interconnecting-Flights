package com.lepsec.interconnectingflights.controllers;

import com.lepsec.interconnectingflights.domain.Schedule;
import com.lepsec.interconnectingflights.integration.RyanairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonatannietoa on 06/03/2017.
 */
@RestController
public class HomeController {
    private RyanairService ryanairService;

    @Autowired
    public HomeController(RyanairService ryanairService) {
        this.ryanairService = ryanairService;
    }

    @RequestMapping(name = "/")
    public Schedule getIndex(){
        return ryanairService.getSchedule("DUB", "WRO", 2017, 3);
    }
}
