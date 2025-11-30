package com.pravisolutions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Refer lombok learning to understand this
//@Builder
@NoArgsConstructor
public class User {

    private Long id; //64 bit integer, compatible with mysql big integer
    //Why not use string? : Well you can user string but string operations are heavy in terms of computation
    private String firstName;
    private String lastName;
    private String email;


    public User(String fname, String lname, String email) {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
    }

}
