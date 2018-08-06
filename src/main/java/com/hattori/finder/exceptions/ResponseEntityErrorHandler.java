package com.hattori.finder.exceptions;

import java.util.Arrays;

import com.hattori.finder.dto.ResponseHttpStatusError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ResponseEntityErrorHandler
 */
@RestControllerAdvice
public class ResponseEntityErrorHandler extends BaseHttpStatusError {

    @ExceptionHandler(StoreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseHttpStatusError notFoundException(StoreNotFoundException e) {
        return new ResponseHttpStatusError(HttpStatus.NOT_FOUND, Arrays.asList(e.getMessage()));
    }

}