package com.lepsec.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jonatannietoa on 06/03/2017.
 */
@Configuration
public class RestConfiguration {
    /**
     * Rest template Bean.
     *
     * @return the rest template bean
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
