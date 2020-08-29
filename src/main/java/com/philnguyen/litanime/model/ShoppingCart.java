package com.philnguyen.litanime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @JsonProperty("cart_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cart")
    @JsonIgnoreProperties("cart")
    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public void removeFromCart(CartItem cartItem) {
        this.cartItems.remove(cartItem);
    }
}
