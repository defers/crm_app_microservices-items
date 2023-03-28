package com.defers.crm.items.service;

import com.defers.crm.items.domain.Item;
import com.defers.crm.items.repository.ItemRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Data
@Service
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService{
    private ItemRepository itemRepository;

    @Transactional
    @Override
    public Mono<Item> save(Item item) {
        itemRepository.save(item);
        return null;
    }

    @Transactional
    @Override
    public Mono<Item> update(Item item) {
        return null;
    }

    @Override
    public Mono<Item> findById(ObjectId id) {
        return null;
    }

    @Override
    public Flux<Item> findAll() {
        return null;
    }
}
