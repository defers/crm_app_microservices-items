package com.defers.crm.items.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "item_file")
public class ItemFile extends BaseEntity{
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    @Field(value = "path")
    private String path;
    @Field(value = "item")
    @DocumentReference
    private Item item;
}
