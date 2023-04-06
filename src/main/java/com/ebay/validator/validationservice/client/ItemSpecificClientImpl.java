package com.ebay.validator.validationservice.client;

import com.ebay.validator.validationservice.model.Item;
import com.ebay.validator.validationservice.util.ItemsSpecificProp;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ItemSpecificClientImpl extends ItemBaseClient implements ItemSpecificClient {

    public ItemSpecificClientImpl(WebClient.Builder webClient, ItemsSpecificProp specificProp) {
        super(webClient, specificProp);
    }

    @Override
    public Mono<String> normalizeItemSpecific(String itemSpecific) {
        //mock endpoint
        getClient().get().uri("/specific/%s".formatted(itemSpecific)).retrieve()
                .bodyToMono(String.class);
        String sentenceCase = normalize(itemSpecific);

        return Mono.just(sentenceCase);
    }

    private String normalize(String itemSpecific) {
        char ch = itemSpecific != null ? itemSpecific.charAt(0): '\0';
        String others = itemSpecific != null ? itemSpecific.substring(1) : "";
        String sentenceCase = Character.toUpperCase(ch)+others;
        System.out.println("normalize "+sentenceCase);
        return sentenceCase;
    }
}
