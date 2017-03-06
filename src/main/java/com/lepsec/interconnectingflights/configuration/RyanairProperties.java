package com.lepsec.interconnectingflights.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

/**
 * Created by jonatannietoa on 06/03/2017.
 */
@ConfigurationProperties("ryanair")
public class RyanairProperties {
    private final Api api = new Api();

    /**
     * Gets api property Object.
     *
     * @return the api
     */
    public Api getApi() {
        return this.api;
    }

    /**
     * The type Api.
     */
    public static class Api {
        @NotNull
        private String routes;

        /**
         * Gets routes URL from application.properties.
         *
         * @return the routes
         */
        public String getRoutes() {
            return routes;
        }

        /**
         * Sets application.properties routes URL.
         *
         * @param routes the routes URL
         */
        public void setRoutes(String routes) {
            this.routes = routes;
        }
    }
}
