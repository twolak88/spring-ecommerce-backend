package com.twolak.springframework.springecommercebackend.dto;

import java.util.Set;

import com.twolak.springframework.springecommercebackend.domain.Address;
import com.twolak.springframework.springecommercebackend.domain.Customer;
import com.twolak.springframework.springecommercebackend.domain.Order;
import com.twolak.springframework.springecommercebackend.domain.OrderItem;

import lombok.Data;

@Data
public class Purchase {
  private Customer customer;
  private Address shippingAddress;
  private Address billingAddress;
  private Order order;
  private Set<OrderItem> orderItems;
}
