package com.tdh.mybatisplus.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Author : TYQ
 * @Date: 2020-09-16 21:48
 */
@ControllerAdvice
@Slf4j
public class ExecptionHandler {

    @ExceptionHandler(value = BindException.class)
    public void argumentBindExceptionHandler(HttpServletRequest request, HttpServletResponse response, Object handler, BindException exception)
            throws IOException {

        BindingResult bindResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindResult.getFieldErrors();
        String fieldError = fieldErrors.get(0).getDefaultMessage();
        log.error(fieldError, exception);
        WebUtil.writeJsonToResponse(response, R.failed(fieldError));

    }

    @ExceptionHandler(value = MarsLdException.class)
    public void basicExceptionHandler(HttpServletRequest request, HttpServletResponse response, Object handler, MarsLdException exception)
            throws IOException {

        log.error(exception.getMessage(), exception);
        WebUtil.writeJsonToResponse(response, R.failed(exception.getMessage()));
    }



    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public void argumentBindExceptionHandler(HttpServletRequest request, HttpServletResponse response, Object handler,
                                             MethodArgumentNotValidException exception) throws IOException {

        BindingResult bindResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindResult.getFieldErrors();
        String fieldError = fieldErrors.get(0).getDefaultMessage();
        log.error(fieldError, exception);
        WebUtil.writeJsonToResponse(response, R.failed(fieldError));
    }




    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public void missRequestParameterExceptionHandler(HttpServletRequest request, HttpServletResponse response, Object handler,
                                                     MissingServletRequestParameterException exception) throws IOException {

        log.error("缺少必填参数", exception);
        WebUtil.writeJsonToResponse(response, R.failed("缺少必填参数["+exception.getParameterName()+"]"));
    }

    @ExceptionHandler(value = Exception.class)
    public void runtimeExceptionHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
            throws IOException {

        log.error(exception.getMessage(), exception);
        WebUtil.writeJsonToResponse(response, R.failed("系统繁忙，请稍后再试"));

    }

}
