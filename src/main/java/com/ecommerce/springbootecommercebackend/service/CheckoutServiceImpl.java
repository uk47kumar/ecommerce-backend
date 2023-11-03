package com.ecommerce.springbootecommercebackend.service;

import com.ecommerce.springbootecommercebackend.dao.CustomerRepository;
import com.ecommerce.springbootecommercebackend.dto.Purchase;
import com.ecommerce.springbootecommercebackend.dto.PurchaseResponse;
import com.ecommerce.springbootecommercebackend.entity.Customer;
import com.ecommerce.springbootecommercebackend.entity.Order;
import com.ecommerce.springbootecommercebackend.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItem
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate order with customer
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        // UUID -> Universally Unique IDentifier

        return UUID.randomUUID().toString();
    }
}
