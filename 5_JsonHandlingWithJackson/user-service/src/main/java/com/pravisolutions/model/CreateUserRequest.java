package com.pravisolutions.model;

/**
 * Why we need separate class to support create?
 * Ans: As per our design, ID field is gettin generated internally. Also when we have seprate class, we have better
 * control for field validation
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateUserRequest {
    /*
       In Java we use camelCase naming convention for property but when it gets serialize in json, appropriate convention should be used.
       In Json, camel_case is more popular. with @JsonProperty we can achive it.
   */
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String email;
}
