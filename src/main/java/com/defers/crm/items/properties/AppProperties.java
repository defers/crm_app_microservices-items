package com.defers.crm.items.properties;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AppProperties {
    public AppProperties() {}
    @Value("${app.web.host}")
    private String host;
    @Value("${app.web.port}")
    private int port;
    @Value("${app.mongo.database.name}")
    private String dbName;
    @Value("${app.mongo.database.host}")
    private String dbHost;
    @Value("${app.mongo.database.port}")
    private String dbPort;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }
    public String getDbHost() {
        return dbHost;
    }
    public String getDbPort() {
        return dbPort;
    }
}
