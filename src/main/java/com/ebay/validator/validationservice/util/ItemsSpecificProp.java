package com.ebay.validator.validationservice.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="ebay", ignoreUnknownFields = false)
public record ItemsSpecificProp(
        String specificsUrl
) {
}
