package com.hattori.finder.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ResponseHttpStatusError
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHttpStatusError {

    private HttpStatus status;
    private List<String> messages;

}