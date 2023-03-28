package com.defers.crm.items.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collation = "items")
public class Item extends BaseEntity{
    @Id
    private ObjectId id;
    @Field(value = "name")
    private String name;
    @Field(value = "current_image")
    @DocumentReference
    private ItemFile currentImage;
    @Field(value = "images")
    @DocumentReference
    private List<ItemFile> images;
}
