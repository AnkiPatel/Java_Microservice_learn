package com.pravisolutions.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;


//Use to automatically detect the class and treat as a bean.
@Component
@Scope("prototype")
public class Student {

    @Autowired
    public Address address;

    public String name;

    public Student() {
        System.out.println("Prototype bean created");
        this.name = "Eva";
        name = name +" "+ new Date().toString();
    }

    public Student(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address=" + address.getAddressValue() +
                ", name='" + name + '\'' +
                '}';
    }
}
