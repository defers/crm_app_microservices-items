package com.defers.crm.items.configuration;

import com.defers.crm.items.properties.AppProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@RequiredArgsConstructor
@EnableReactiveMongoAuditing
@Configuration
public class MongoDBConfiguration extends AbstractReactiveMongoConfiguration {
    private final AppProperties appProperties;

    @Override
    protected String getDatabaseName() {
        return appProperties.getDbName();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json().build();
    }
    @Bean
    public MongoClientSettings mongoClientSettings() {
        ConnectionString connectionString = new ConnectionString(getConnectionString());
        return MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .retryWrites(false)
                .build();
    }

    // TODO login and password must be not hard coded
    private String getConnectionString() {
        return "mongodb://admin:admin@%s:%s"
                .formatted(
                        appProperties.getDbHost(),
                        appProperties.getDbPort()
                );
    }

    @Bean
    public MongoClient mongoClient(MongoClientSettings mongoClientSettings) {
        return MongoClients.create(mongoClientSettings);
    }
}
