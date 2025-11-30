package com.pravisolutions.model;

/**
 * Why we need separate class to support create?
 * Ans: As per our design, ID field is gettin generated internally. Also when we have seprate class, we have better
 * control for field validation
 */
import lombok.Data;

@Data
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
}
