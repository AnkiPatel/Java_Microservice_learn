package com.pravisolutions.model;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable /*With this, property of this class will be directly become columns for that entity which is including
this class as composition*/
public class UserInfo {
    private String gender;
    private String phone;
}
