package com.defers.crm.items.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ItemHandler {
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .body(BodyInserters.fromValue("test yo!"));
    }
}
