package com.defers.crm.items.handler;

import com.defers.crm.items.domain.Item;
import com.defers.crm.items.exception.EntityNotFoundException;
import com.defers.crm.items.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Component
public class ItemHandler {
    private final ItemService itemService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        log.info("find all items method invoked...");
        Flux<Item> items = itemService.findAll();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_NDJSON)
                .body(items, Item.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        log.info("save item method invoked...");
        Mono<Item> itemMono = request.bodyToMono(Item.class).log();

        return itemMono.flatMap(item -> itemService.save(item))
                .flatMap(
                        item -> ServerResponse
                                .created(UriComponentsBuilder
                                        .fromUri(request.uri())
                                        .path("/{id}")
                                        .build(item.getId()))
                                .contentType(MediaType.APPLICATION_NDJSON)
                                .body(BodyInserters.fromValue(item))
                );
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<Item> item = itemService.findById(new ObjectId(id));
        return item
                .switchIfEmpty(Mono.error(new EntityNotFoundException("Item with id %s not found!".formatted(id))))
                .flatMap(
                        e -> ServerResponse
                                .ok()
                                .contentType(MediaType.APPLICATION_NDJSON)
                                .body(Mono.just(e), Item.class)
                );
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<Item> itemMono = request.bodyToMono(Item.class);
        return itemMono.flatMap(e -> {
            ObjectId objId = new ObjectId(id);
            return itemService.update(e, objId);
        })
                .flatMap(e -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_NDJSON)
                        .body(Mono.just(e), Item.class)
                );
    }
}
