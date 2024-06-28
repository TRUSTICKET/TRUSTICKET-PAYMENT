package com.trusticket.trusticketpayment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PaymentData {
    private String bookingId;
    private String paymentId;
}
