package com.trusticket.trusticketpayment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private Long paymentId;

    @Column(name = "IMP_UID", nullable = false)
    private String impUid;

    @Column(name = "MEMBER_ID", nullable = false)
    private Long memberId;

    @Column(name = "BOOKING_ID", nullable = false)
    private Long bookingId;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

}
