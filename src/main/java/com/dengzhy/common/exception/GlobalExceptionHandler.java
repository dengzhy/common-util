package com.dengzhy.common.exception;


import com.dengzhy.common.enums.ApiExceptionEnum;
import com.dengzhy.common.result.ResultWrapper;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Map;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description:
 * @Author dengzhy
 * @Date 2018/08/01 10:08
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public Map<String, Object> apiExceptionHandler(ApiException ex) {
        return ResultWrapper.fail(ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception ex) {

        logger.error("【异常捕获】" + ExceptionUtils.getStackTrace(ex));
        ApiException apiException = new ApiException();
        if (ex instanceof NoHandlerFoundException) {
            apiException.setErrCode("404");
            apiException.setMessage(ex.getMessage());
        } else {
            apiException = new ApiException(ApiExceptionEnum.DEFAULT_ERROR);
        }

        return ResultWrapper.fail(apiException);
    }
}
