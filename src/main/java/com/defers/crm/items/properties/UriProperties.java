package com.defers.crm.items.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UriProperties {
    @Value("${app.uri.prefix}")
    private String apiPrefixUri;
    @Value("${app.uri.version}")
    private String versionUri;
    @Value("${app.uri.items}")
    private String itemsUri;

    public String getItemsUri(){
        return  getPrefix() + itemsUri;
    }
    private String getPrefix() {
        return apiPrefixUri + "/" + versionUri + "/";
    }
}
