package com.defers.crm.items;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.netty.http.server.HttpServer;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@EnableReactiveMongoRepositories
@ComponentScan
public class ItemsApplication {
    public static void main(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ItemsApplication.class);
        startServer(context);
    }

    private static void startServer(AnnotationConfigApplicationContext context) {
        HttpServer server = context.getBean(HttpServer.class);
        server.bindUntilJavaShutdown(Duration.ofSeconds(60),
                (disposableServer) -> log.info("Server has started on host: {} port: {} at: {}",
                        disposableServer.host(),
                        disposableServer.port(),
                        ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-ddТHH:mm:ss['['VV']']"))));
    }
}
