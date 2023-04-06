package com.ebay.validator.validationservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

public interface Item {
    String getSiteId();
    String getCategoryId();
    String getTitle();
    String getCondition();
    BigDecimal getPrice();
    int getQuantity();
    Set<String> getImageUrl();
    Set<String> getItemSpecifics();
    String getDescription();
}
