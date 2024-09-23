package com.in28minutes.rest.webservices.restful_web_services.exception;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
