package com.trusticket.trusticketpayment.service;

import com.trusticket.trusticketpayment.common.kafka.KafkaProducer;
import com.trusticket.trusticketpayment.domain.Payment;
import com.trusticket.trusticketpayment.dto.PaymentData;
import com.trusticket.trusticketpayment.dto.PaymentRequest;
import com.trusticket.trusticketpayment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final KafkaProducer kafkaProducer;


    @Transactional
    public boolean requestPayment(PaymentRequest req){
        Payment payment = Payment.builder()
                .amount(req.getAmount())
                .impUid(req.getImpUid())
                .bookingId(req.getBookingId())
                .memberId(req.getMemberId())
                .build();

        payment = paymentRepository.save(payment);

        String booking = payment.getBookingId().toString();
        kafkaProducer.sendPaymentSuccess("payment-success", new PaymentData(booking, payment.getPaymentId().toString()));
        return true;
    }

}
