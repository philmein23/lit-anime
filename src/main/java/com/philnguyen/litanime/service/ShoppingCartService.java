package com.philnguyen.litanime.service;

import com.philnguyen.litanime.dto.CartItemDto;
import com.philnguyen.litanime.model.CartItem;
import com.philnguyen.litanime.model.Product;
import com.philnguyen.litanime.model.ShoppingCart;
import com.philnguyen.litanime.repository.ProductRepository;
import com.philnguyen.litanime.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private ProductRepository productRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public ShoppingCart addProductToShoppingCart(Long cartId, CartItemDto cartItemDto) throws Exception {
        return (ShoppingCart) shoppingCartRepository
                .findById(cartId)
                .map(cart -> {
                    Product foundProduct = productRepository
                            .findById(cartItemDto.getProductId())
                            .orElse(null);

                    if (foundProduct.equals(null)) {
                        return new Exception("Product could not be found");
                    }
                    CartItem newCartItem = new CartItem();

                    newCartItem.setQuantity(cartItemDto.getQuantity());
                    newCartItem.setProduct(foundProduct);
                    newCartItem.setCart(cart);

                    cart
                            .getCartItems()
                            .add(newCartItem);

                    return shoppingCartRepository.save(cart);
                })
                .orElseGet(() -> {
                    Product foundProduct = productRepository
                            .findById(cartItemDto.getProductId())
                            .orElse(null);

                    if (foundProduct.equals(null)) {
                        return new Exception("Product could not be found");
                    }

                    CartItem newCartItem = new CartItem();
                    ShoppingCart shoppingCart = new ShoppingCart();

                    newCartItem.setQuantity(cartItemDto.getQuantity());
                    newCartItem.setProduct(foundProduct);
                    newCartItem.setCart(shoppingCart);

                    shoppingCart
                            .getCartItems()
                            .add(newCartItem);

                    return shoppingCartRepository.save(shoppingCart);
                });

    }


}
