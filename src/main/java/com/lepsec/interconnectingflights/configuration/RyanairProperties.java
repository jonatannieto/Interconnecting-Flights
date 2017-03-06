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

        @NotNull
        private String schedule;

        /**
         * Gets routes URL from application.properties.
         *
         * @return the Api routes URL
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

        /**
         * Gets schedule URL from application.properties.
         *
         * @return the Api schedule URL
         */
        public String getSchedule() {
            return schedule;
        }

        /**
         * Sets application.properties schedule URL.
         *
         * @param schedule the Api routes URL
         */
        public void setSchedule(String schedule) {
            this.schedule = schedule;
        }
    }
}
