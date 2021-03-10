package com.twolak.springframework.springecommercebackend.controller;

import com.twolak.springframework.springecommercebackend.dto.Purchase;
import com.twolak.springframework.springecommercebackend.dto.PurchaseResponse;
import com.twolak.springframework.springecommercebackend.service.CheckoutService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

  private final CheckoutService checkoutService;

  public CheckoutController(CheckoutService checkoutService) {
    this.checkoutService = checkoutService;
  }

  @PostMapping("/purchase")
  public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
    PurchaseResponse purchaseResponse = this.checkoutService.placeOrder(purchase);
    return purchaseResponse;
  }
}
