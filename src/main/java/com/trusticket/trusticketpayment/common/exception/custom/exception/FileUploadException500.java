package com.trusticket.trusticketpayment.common.exception.custom.exception;

import com.trusticket.trusticketpayment.common.ErrorDefineCode;
import com.trusticket.trusticketpayment.common.exception.custom.BasicCustomException500;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 500 : 파일 업로드에 실패한 경우
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileUploadException500 extends BasicCustomException500 {
    public FileUploadException500(ErrorDefineCode code) {
        super(code);
    }
}