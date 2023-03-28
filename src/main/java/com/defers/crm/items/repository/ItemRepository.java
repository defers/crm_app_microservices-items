package com.defers.crm.items.repository;

import com.defers.crm.items.domain.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, ObjectId> {
}
