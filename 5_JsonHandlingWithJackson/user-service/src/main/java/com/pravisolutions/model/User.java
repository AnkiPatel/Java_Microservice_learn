package com.pravisolutions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //Refer lombok learning to understand this
//@Builder
@NoArgsConstructor
// @JsonIgnoreProperties(value = {"id"}) // Class level annotation and still you can declare "JsonIgnore" for specific property.
//@JsonInclude(JsonInclude.Include.NON_NULL) // With this we say, only include "non-null" fields during serialization
public class User {

    //Consider we dont want id to be included when jackson do serialization of this object in json.
    @JsonIgnore
    private Long id; //64 bit integer, compatible with mysql big integer
    //Why not use string? : Well you can user string but string operations are heavy in terms of computation

    /*
       In Java we use camelCase naming convention for property but when it gets serialize in json, appropriate convention should be used.
       In Json, camel_case is more popular. with @JsonProperty we can achive it.
   */
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Date created;


    public User(String fname, String lname, String email) {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
    }

}
