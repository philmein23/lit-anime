package com.philnguyen.litanime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("customer_id")
    private Long customerId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String email;

    @JsonProperty("user_name")
    private String userName;

    private String password;

    private String address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    private ShoppingCart cart;
}
