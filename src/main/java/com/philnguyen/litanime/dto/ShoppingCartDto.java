package com.philnguyen.litanime.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingCartDto {

    private List<Long> productIds;
}
