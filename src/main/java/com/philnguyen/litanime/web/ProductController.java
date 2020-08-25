package com.philnguyen.litanime.web;

import com.philnguyen.litanime.dto.ProductDto;
import com.philnguyen.litanime.model.Product;
import com.philnguyen.litanime.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<?> addNewProduct(@RequestBody ProductDto newProduct) {

        Product product = productService.addNewProduct(newProduct.getProductName(), newProduct.getDescription(), newProduct.getProductType(), newProduct.getPrice());

        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/{productType}")
    public ResponseEntity<?> findProductByType(@PathVariable String productType) {
        return ResponseEntity.ok(productService.findProductByType(productType));
    }

}
