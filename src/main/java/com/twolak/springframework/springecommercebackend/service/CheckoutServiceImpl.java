package com.twolak.springframework.springecommercebackend.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import com.twolak.springframework.springecommercebackend.domain.Customer;
import com.twolak.springframework.springecommercebackend.domain.Order;
import com.twolak.springframework.springecommercebackend.domain.OrderItem;
import com.twolak.springframework.springecommercebackend.dto.Purchase;
import com.twolak.springframework.springecommercebackend.dto.PurchaseResponse;
import com.twolak.springframework.springecommercebackend.repositories.CustomerRepository;

import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService {

  private final CustomerRepository customerRepository;

  public CheckoutServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  @Transactional
  public PurchaseResponse placeOrder(Purchase purchase) {
    Order order = purchase.getOrder();

    String orderTrackingNumber = generateOrderTrackingNumber();
    order.setOrderTrackingNumber(orderTrackingNumber);
    
    Set<OrderItem> orderItems = purchase.getOrderItems();
    orderItems.forEach(orderItem -> {
      order.add(orderItem);
    });

    order.setBillingAddress(purchase.getBillingAddress());
    order.setShippingAddress(purchase.getShippingAddress());

    Customer customer = purchase.getCustomer();
    customer.add(order);

    customerRepository.save(customer);

    return PurchaseResponse.builder().orderTrackingNumber(orderTrackingNumber).build();
  }

  private String generateOrderTrackingNumber() {
    return UUID.randomUUID().toString();
  }
  
}
