package org.fanyi.fanyibackend.exception;

import org.fanyi.fanyibackend.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = FanyiException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO<String> handleAIExternalException(FanyiException e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        String stackTrace = stringWriter.toString();
        logger.info("An exception occurred: {}\n{}", e.getMessage(), stackTrace);
        return ResponseVO.buildErrorResponse(e.getMessage(), "");
    }
}

