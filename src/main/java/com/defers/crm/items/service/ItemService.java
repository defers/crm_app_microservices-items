package com.defers.crm.items.service;

import com.defers.crm.items.domain.Item;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemService {
    Mono<Item> save(Item item);
    Mono<Item> update(Item item, ObjectId id);
    Mono<Item> findById(ObjectId id);
    Flux<Item> findAll();
}
