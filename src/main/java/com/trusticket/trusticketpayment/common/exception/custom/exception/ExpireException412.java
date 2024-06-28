package com.trusticket.trusticketpayment.common.exception.custom.exception;


import com.trusticket.trusticketpayment.common.ErrorDefineCode;
import com.trusticket.trusticketpayment.common.exception.custom.BasicCustomException500;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 412 : 시간이 만료된 자원에 접근할 때
 */
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class ExpireException412 extends BasicCustomException500 {
    public ExpireException412(ErrorDefineCode code) {
        super(code);
    }
}