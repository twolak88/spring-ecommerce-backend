package com.twolak.springframework.springecommercebackend.repositories;

import com.twolak.springframework.springecommercebackend.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}
