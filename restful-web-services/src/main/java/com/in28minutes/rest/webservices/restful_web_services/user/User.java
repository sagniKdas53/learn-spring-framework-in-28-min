package com.in28minutes.rest.webservices.restful_web_services.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class User {
    private Integer id;
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    //private String description;
    @Past(message = "BirthDate should be in the past")
    private LocalDate birthDate;
    //private LocalDateTime createdDate;
    // private LocalDateTime updatedDate;
}
