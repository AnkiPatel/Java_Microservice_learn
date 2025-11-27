package com.pravisolutions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//Mark class as configuration class
@Configuration
public class AppConfiguration {

    @Bean(name = "student_bean") //Translate that Studen will be bean while resolving dependency injection
    @Scope(value = "prototype") // "singleton" is the default value
    public Student getStudent() {  // Here name of the method does not matter.
        return new Student();
    }

    @Bean(name = "address_bean_one")
    public Address getAddressOne() {
        return new Address("Peninsula Prakruthi");
    }

    @Bean(name = "address_bean_two")
    public Address getAddressTwo() {
        return new Address("Sarjapura");
    }
}
