package com.ebay.validator.validationservice.controller;

import com.ebay.validator.validationservice.model.Item;
import com.ebay.validator.validationservice.model.ResponseWrapper;
import com.ebay.validator.validationservice.model.dto.ItemDto;
import com.ebay.validator.validationservice.service.ValidationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1/validate")
public class ItemController {

    @Autowired
    private ValidationService validatorService;

    @PostMapping
    public Mono<ResponseWrapper<? extends Item>> validateItem(@RequestBody @Valid ItemDto itemDto){
            return validatorService
                    .validate(itemDto)
                    .map(ResponseWrapper::VALID);
    }
}
