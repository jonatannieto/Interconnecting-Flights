package com.lepsec.controllers;

import com.lepsec.domain.Route;
import com.lepsec.integration.RyanairRoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jonatannietoa on 06/03/2017.
 */
@RestController
public class HomeController {
    private RyanairRoutesService ryanairRoutesService;

    @Autowired
    public HomeController(RyanairRoutesService ryanairRoutesService) {
        this.ryanairRoutesService = ryanairRoutesService;
    }

    @RequestMapping(name = "/")
    public List<Route> getIndex(){
        return ryanairRoutesService.getRoutes();
    }
}
