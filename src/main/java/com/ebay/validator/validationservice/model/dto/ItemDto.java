package com.ebay.validator.validationservice.model.dto;

import com.ebay.validator.validationservice.model.Item;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Data
public class ItemDto implements Item {
    @NotEmpty
    @Size(min=2, message = "Site id should have at least 4 characters")
    private String siteId;
    @NotEmpty
    private String categoryId;
    @NotEmpty @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,}$", message = "Title must be a valid title ")
    private String title;
    @NotEmpty @NotNull
    @Pattern(regexp = "^[a-zA-Z.s]{3,}$", message = "Condition must be a valid condition with no special character")
    private String condition;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
    private BigDecimal price;
    private int quantity;
    private Set<String> imageUrl;
    @NotNull @NotEmpty
    @Size(min = 1, max = 2, message = "ItemSpecifics should contain at most 2 specifics")
    private Set<String> itemSpecifics;
    @NotEmpty @NotNull
    @Size(min = 5, max = 500, message = "Description should not be more than 500 letters")
    private String description;


}
