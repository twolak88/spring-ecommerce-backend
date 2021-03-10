package com.twolak.springframework.springecommercebackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseResponse {

  private String orderTrackingNumber;
}
