package com.ebay.validator.validationservice.client;

import reactor.core.publisher.Mono;

public interface ItemSpecificClient {

    Mono<String> normalizeItemSpecific(String itemSpecific);
}
