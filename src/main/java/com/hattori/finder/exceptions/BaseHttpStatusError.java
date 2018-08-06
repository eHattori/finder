package com.hattori.finder.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

import com.hattori.finder.dto.ResponseHttpStatusError;

import org.springframework.http.HttpStatus;

/**
 * BaseHttpStatusError
 */
public class BaseHttpStatusError {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseHttpStatusError unknownException(Exception ex) {
        return new ResponseHttpStatusError(HttpStatus.INTERNAL_SERVER_ERROR, Arrays.asList(ex.getMessage()));
    }

}