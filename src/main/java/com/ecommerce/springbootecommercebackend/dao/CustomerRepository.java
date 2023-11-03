package com.ecommerce.springbootecommercebackend.dao;

import com.ecommerce.springbootecommercebackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
