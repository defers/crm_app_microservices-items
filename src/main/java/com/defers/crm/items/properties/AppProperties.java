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

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

}
