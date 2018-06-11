package com.kee.sptringbootmastergradle.exception;

import com.kee.sptringbootmastergradle.utils.net.resultpojo.ErrorTypeEnum;
import com.kee.sptringbootmastergradle.utils.net.resultpojo.ResultJsonBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResultJsonBean defaultErrorHandler(HttpServletRequest request, Exception ex) throws Exception {
        ex.printStackTrace();
        return ResultJsonBean.returnError(ErrorTypeEnum.UNKONW_ERR, ex.getMessage());
    }
}
