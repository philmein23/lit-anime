package com.philnguyen.litanime.service;

import com.philnguyen.litanime.model.Product;
import com.philnguyen.litanime.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return StreamSupport
                .stream(productRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public Product addNewProduct(String productName, String description, String productType, float price) {
        Product product = new Product();

        product.setProductName(productName);
        product.setDescription(description);
        product.setProductType(productType);
        product.setPrice(price);

        return productRepository.save(product);
    }

    @Transactional
    public List<Product> findProductByType(String productType) {
        return productRepository.findProductByType(productType);
    }
}
