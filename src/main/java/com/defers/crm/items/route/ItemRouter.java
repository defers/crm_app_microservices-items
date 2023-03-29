package com.defers.crm.items.route;

import com.defers.crm.items.handler.ItemHandler;
import com.defers.crm.items.properties.UriProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ItemRouter {
    private UriProperties uriProperties;

    @Autowired
    public ItemRouter(UriProperties uriProperties) {
        this.uriProperties = uriProperties;
    }

    @Bean
    public RouterFunction<ServerResponse> routes(ItemHandler itemHandler) {

        return RouterFunctions.route()
                .GET(uriProperties.getItemsUri(), request -> itemHandler.findAll(request))
                .GET(uriProperties.getItemsUri() + "/{id}", request -> itemHandler.findById(request))
                .PUT(uriProperties.getItemsUri() + "/{id}", accept(MediaType.APPLICATION_NDJSON), request -> itemHandler.update(request))
                .POST(uriProperties.getItemsUri(), accept(MediaType.APPLICATION_NDJSON), request -> itemHandler.save(request))
                .build();
    }
}
