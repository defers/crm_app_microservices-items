package com.defers.crm.items.route;

import com.defers.crm.items.handler.ItemHandler;
import com.defers.crm.items.properties.UriProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ItemRouter {
    private UriProperties uriProperties;

    @Autowired
    public ItemRouter(UriProperties uriProperties) {
        this.uriProperties = uriProperties;
    }

    @Bean
    public RouterFunction<ServerResponse> routes(ItemHandler itemHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET(uriProperties.getItemsUri()), (request) -> itemHandler.findAll(request)
        );
    }
}
