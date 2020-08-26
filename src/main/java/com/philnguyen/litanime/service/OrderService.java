package com.philnguyen.litanime.service;

import com.philnguyen.litanime.dto.ProductDto;
import com.philnguyen.litanime.model.Order;
import com.philnguyen.litanime.model.OrderItem;
import com.philnguyen.litanime.model.Product;
import com.philnguyen.litanime.repository.OrderRepository;
import com.philnguyen.litanime.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public List<Order> findAllOrders() {
        return StreamSupport
                .stream(orderRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public Order createNewOrder(List<ProductDto> products) {
        Order newOrder = new Order();
        Timestamp orderDate = new Timestamp(new Date().getTime());
        newOrder.setOrderStatus("NEW");
        newOrder.setOrderDate(orderDate);

        for (ProductDto product : products) {
            Product newProduct = new Product();
            newProduct.setProductName(product.getProductName());
            newProduct.setDescription(product.getDescription());
            newProduct.setProductType(product.getProductType());
            newProduct.setPrice(product.getPrice());

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(newProduct);
            orderItem.setQuantity(4);

            newOrder.addOrderItem(orderItem);
        }

        return orderRepository.save(newOrder);
    }
}
