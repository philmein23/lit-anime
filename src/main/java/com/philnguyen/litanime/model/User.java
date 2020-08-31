package com.philnguyen.litanime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String email;

    @JsonProperty("user_name")
    private String userName;

    private String password;

    private String address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private ShoppingCart cart;
}
