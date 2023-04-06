package com.ebay.validator.validationservice.client;

import com.ebay.validator.validationservice.util.ItemsSpecificProp;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;

public abstract class ItemBaseClient {
    @Getter
    private final WebClient client;

    public ItemBaseClient(@Qualifier("authorized") WebClient.Builder webClient, ItemsSpecificProp specificProp) {
        this.client = webClient
                .baseUrl("/ebay/%s".formatted(specificProp.specificsUrl())).build();
    }
}
