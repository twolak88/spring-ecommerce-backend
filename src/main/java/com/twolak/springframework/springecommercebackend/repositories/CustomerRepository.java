package com.twolak.springframework.springecommercebackend.repositories;

import com.twolak.springframework.springecommercebackend.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
