package com.pravisolutions.model;


/**
 * Why we need separate class to support update?
 * Ans: With separate class we can control which are the field for which API user is allowed to update the object.
 */

import lombok.Data;

@Data
public class PatchUserRequest {

    private String firstName;
    private String lastName;
    private String email;
}
