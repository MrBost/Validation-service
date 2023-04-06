package com.ebay.validator.validationservice.service;

import com.ebay.validator.validationservice.client.ItemSpecificClient;
import com.ebay.validator.validationservice.model.Item;
import com.ebay.validator.validationservice.model.dto.ItemDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ValidationServiceImpl implements ValidationService{

    @Autowired
    private ItemSpecificClient client;
    @Override
    public Mono<? extends Item> validate(ItemDto itemDto) {
        System.out.println("now validatingggg");
        return validateItem(itemDto)
                .map(e -> e.getItemSpecifics().stream().map(it->{
                    System.out.println("item specific "+e.getItemSpecifics());
                    Mono<String> stringMono = null;
                    try {
                        Thread.sleep(1000);
                        stringMono = normalizeItemSpecific(it);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("stringmono "+stringMono.toString());
                    return stringMono;

                }))
                .map(it-> itemDto);
    }

    public Mono<String> normalizeItemSpecific(String item) {
        return client.normalizeItemSpecific(item);
    }

    public Mono<Item> validateItem(ItemDto itemDto){
        //invoke the selling service
        System.out.println("itemdto "+ itemDto.toString());
        return Mono.just(itemDto);
    }
}
