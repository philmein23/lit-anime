package com.philnguyen.litanime.service;

import com.philnguyen.litanime.dto.ProductDto;
import com.philnguyen.litanime.model.Order;
import com.philnguyen.litanime.model.Product;
import com.philnguyen.litanime.repository.OrderRepository;
import com.philnguyen.litanime.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @Transactional
    public Order createNewOrder(List<ProductDto> products) {
        Order newOrder = new Order();
        Timestamp orderDate = new Timestamp(new Date().getTime());
        newOrder.setOrderStatus("NEW");
        newOrder.setOrderDate(orderDate);

        for (ProductDto product : products) {
            Product newProduct = productService.addNewProduct(product.getProductName(), product.getDescription(), product.getProductType(), product.getPrice());

            newOrder.getProducts().add(newProduct);
        }

        System.out.println(newOrder);

        return orderRepository.save(newOrder);
    }
}
