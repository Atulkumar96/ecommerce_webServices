package com.ecom.ecom_productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SendEmail {
    private String to;
    private String from;
    private String subject;
    private String body;
}
