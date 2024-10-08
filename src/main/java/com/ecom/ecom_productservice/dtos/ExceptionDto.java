package com.ecom.ecom_productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
@AllArgsConstructor
public class ExceptionDto {
    private HttpStatus httpStatus;
    private String message;
}
