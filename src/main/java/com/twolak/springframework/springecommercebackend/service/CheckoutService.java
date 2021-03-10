package com.twolak.springframework.springecommercebackend.service;

import com.twolak.springframework.springecommercebackend.dto.Purchase;
import com.twolak.springframework.springecommercebackend.dto.PurchaseResponse;

public interface CheckoutService {
  
  PurchaseResponse placeOrder(Purchase purchase);
}
