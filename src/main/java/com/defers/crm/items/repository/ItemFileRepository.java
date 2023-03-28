package com.defers.crm.items.repository;

import com.defers.crm.items.domain.ItemFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFileRepository extends ReactiveMongoRepository<ItemFile, ObjectId> {
}
