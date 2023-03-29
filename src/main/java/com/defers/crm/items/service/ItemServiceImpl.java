package com.defers.crm.items.service;

import com.defers.crm.items.domain.Item;
import com.defers.crm.items.repository.ItemRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Data
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Mono<Item> save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Mono<Item> update(Item item, ObjectId id) {
        Mono<Item> itemMono = findById(id);
        return itemMono.flatMap(e -> {
            item.setId(id);
            item.setVersion(e.getVersion());
            return itemRepository.save(item);
        });
    }

    @Override
    public Mono<Item> findById(ObjectId id) {
        Mono<Item> item = itemRepository.findById(id);
        return item;
    }

    @Override
    public Flux<Item> findAll() {
        return itemRepository.findAll();
    }
}
