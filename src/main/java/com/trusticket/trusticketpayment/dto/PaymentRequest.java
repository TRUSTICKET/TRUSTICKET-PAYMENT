package com.trusticket.trusticketpayment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @Schema(description = "포트원 IMP UID", example = "imp1234")
    private String impUid;

    @Schema(description = "유저 ID", example = "1")
    private Long memberId;

    @Schema(description = "티케팅 ID", example = "1")
    private Long bookingId;

    @Schema(description = "결제금액", example = "1000")
    private Long amount;


}
