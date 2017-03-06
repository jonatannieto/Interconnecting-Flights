package com.lepsec;

import com.lepsec.configuration.RyanairProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RyanairProperties.class)
public class InterconnectingflightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterconnectingflightsApplication.class, args);
	}
}
