package com.philnguyen.litanime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDto {
    @JsonProperty("product_name")
    private String productName;
    private float price;
    private String description;
    @JsonProperty("product_type")
    private String productType;
}
