package com.defers.crm.items.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ItemHandler {
    public Mono<ServerResponse> findAll(ServerRequest request) {
        log.info("find all method invoked...");
        return ServerResponse.ok()
                .body(BodyInserters.fromValue("test yo!"));
    }
}
