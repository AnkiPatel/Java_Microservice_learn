package com.pravisolutions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("first_name")
    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    @JsonProperty("last_name")
    private String lastName;

    @Column(length = 50)
    private String email;


    @CreationTimestamp /* It will tell JPA to automatically populate field with timestamp when entity first persist in database*/
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Date created;

    @UpdateTimestamp /* It will tell JPA to automatically populate field with timestamp when entity get updated in database*/
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Date modified;


    public User(String fname, String lname, String email) {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
    }

}
