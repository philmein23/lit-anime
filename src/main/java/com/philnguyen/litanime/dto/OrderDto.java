package com.philnguyen.litanime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.philnguyen.litanime.model.Product;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderDto {
    @JsonProperty("order_status")
    private String orderStatus;

    @JsonProperty("order_date")
    private Timestamp orderDate;

    private List<ProductDto> products;
}
