package com.ecommerce.springbootecommercebackend.service;

import com.ecommerce.springbootecommercebackend.dto.Purchase;
import com.ecommerce.springbootecommercebackend.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
