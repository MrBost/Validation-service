package com.ebay.validator.validationservice.service;

import com.ebay.validator.validationservice.model.Item;
import com.ebay.validator.validationservice.model.dto.ItemDto;
import reactor.core.publisher.Mono;

public interface ValidationService {
    Mono<? extends Item> validate(ItemDto itemDto);
}
