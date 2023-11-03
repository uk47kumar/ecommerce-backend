package com.ecommerce.springbootecommercebackend.dto;

import com.ecommerce.springbootecommercebackend.entity.Address;
import com.ecommerce.springbootecommercebackend.entity.Customer;
import com.ecommerce.springbootecommercebackend.entity.Order;
import com.ecommerce.springbootecommercebackend.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
