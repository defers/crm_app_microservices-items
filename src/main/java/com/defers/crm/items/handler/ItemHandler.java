package com.defers.crm.items.handler;

import com.defers.crm.items.domain.Item;
import com.defers.crm.items.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Component
public class ItemHandler {
    @Autowired
    private final ItemRepository itemRepository;
    public Mono<ServerResponse> findAll(ServerRequest request) {
        log.info("find all method invoked...");
        return ServerResponse.ok()
                .body(BodyInserters.fromValue("test yo!"));
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<Item> itemMono = request.bodyToMono(Item.class).log();

        return itemMono.flatMap(item -> itemRepository.save(item))
                .flatMap(
                        item -> ServerResponse
                                .ok()
                                .contentType(MediaType.APPLICATION_NDJSON)
                                .body(BodyInserters.fromValue(item))
                );
    }
}
