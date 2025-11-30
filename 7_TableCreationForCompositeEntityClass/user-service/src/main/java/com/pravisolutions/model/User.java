package com.pravisolutions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity  /*User will be mapped with table in relational db. It will tell JPA (Hibernate) that it should be managed by persistent context)
When you have @Entity annotation, class must have NoArgsConstructor
You cannot put @Entity annotation on interface. It has to be on light weight concrete class. */

//@Table(name = "user_table")
/*By default, class table will create with class's name. if you want to create different table name
you have to use @Table annotation.
*/
public class User {

    //@JsonIgnore
    @Id //define to mention that this property will be the "Primary key" in table
    @GeneratedValue(strategy = GenerationType.AUTO) // Means we are delegating responsibility to JPA implementor (Hibernate) for generating value automatically.
    private Long id;

    @JsonProperty("first_name")
    @Column(length = 50) // first_name will be the column, and it's value's length can be 50
    private String firstName;

    @Column(length = 50) // last_name will be the column, and it's value's length can be 50
    @JsonProperty("last_name")
    private String lastName;

    @Column(length = 50) // email will be the column, and it's value's length can be 50
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "gender", column = @Column(name = "user_gender")),
            @AttributeOverride(name = "phone", column = @Column(name = "user_phone")),
    })
    private UserInfo userInfo;

    /*
    If you don't use @Column(name = "user_gender"), Springboot will create column name as "gender"
    */

    @Transient //Using this annotation because we dont need this field in DB. There will be NO column for this field in table.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Date created;


    public User(String fname, String lname, String email) {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
    }

}
