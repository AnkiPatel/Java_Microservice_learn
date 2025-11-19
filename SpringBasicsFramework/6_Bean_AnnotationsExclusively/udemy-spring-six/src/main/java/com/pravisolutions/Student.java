package com.pravisolutions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Student {
    private String studentName;

    //Composition
    @Autowired
    @Qualifier( value = "address_bean_two")
    private Address address;

    public Student(Address addr) {
        this.address = addr;
    }

    public Student() {

    }

    public Student(String nameStr) {
        this.studentName = nameStr;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void sayHello() {
        System.out.println(this.studentName + " says hello from spring framework");
    }

    public void showInfo() {
        System.out.println("Name: " + this.studentName+"\nAddress: " + this.address );
    }


}