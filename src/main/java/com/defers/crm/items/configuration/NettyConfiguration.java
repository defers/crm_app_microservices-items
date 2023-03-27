package com.defers.crm.items.configuration;

import com.defers.crm.items.properties.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

@RequiredArgsConstructor
@Configuration
public class NettyConfiguration {
    private final AppProperties appProperties;

    @Bean
    public HttpServer httpServer(ApplicationContext context) {
        HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context).build();
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        return  HttpServer.create()
                .host(appProperties.getHost())
                .port(appProperties.getPort())
                .handle(adapter);
    }
}
