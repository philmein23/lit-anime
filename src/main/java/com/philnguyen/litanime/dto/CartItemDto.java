package com.philnguyen.litanime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CartItemDto {

    private Integer quantity;

    @JsonProperty("product_id")
    private Long productId;
}
