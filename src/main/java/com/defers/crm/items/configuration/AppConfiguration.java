package com.defers.crm.items.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
@PropertySource(value = "classpath:application.properties")
public class AppConfiguration {

}
