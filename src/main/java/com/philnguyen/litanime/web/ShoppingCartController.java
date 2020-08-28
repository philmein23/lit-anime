package com.philnguyen.litanime.web;

import com.philnguyen.litanime.dto.CartItemDto;
import com.philnguyen.litanime.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/cart/{cartId}/add")
    public ResponseEntity<?> addProductToShoppingCart(@PathVariable Long cartId, @RequestBody CartItemDto cartItemDto) throws Exception{
        return ResponseEntity.ok(shoppingCartService.addProductToShoppingCart(cartId, cartItemDto));
    }
}
