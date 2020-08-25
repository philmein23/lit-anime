package com.philnguyen.litanime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("product_id")
    @Column(name = "product_id")
    private Long productId;

    @JsonProperty("product_name")
    private String productName;
    private String description;
    private float price;
    @JsonProperty("product_type")
    private String productType;
}
