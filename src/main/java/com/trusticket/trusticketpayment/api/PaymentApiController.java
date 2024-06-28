package com.trusticket.trusticketpayment.api;

import com.trusticket.trusticketpayment.common.response.CommonResponse;
import com.trusticket.trusticketpayment.dto.PaymentRequest;
import com.trusticket.trusticketpayment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Payment", description = "Payment API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentApiController {
    private final PaymentService paymentService;

    @PostMapping("")
    @Operation(summary = "결제 처리")
    public CommonResponse<Long> paymentRequest(@Valid @RequestBody PaymentRequest req) {
        boolean success = paymentService.requestPayment(req);
        if(success){
            return new CommonResponse<>(true, HttpStatus.OK, "결제 처리가 완료되었습니다.", null);
        }
        else{
            return new CommonResponse<>(false, HttpStatus.INTERNAL_SERVER_ERROR, "결제 처리에 실패하였습다.", null);
        }
    }
}
