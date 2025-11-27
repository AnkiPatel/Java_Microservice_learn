package com.pravisolutions;

public class Student {
    private String studentName;

    //Composition
    private Address address;

    public Student(Address addr) {
        this.address = addr;
    }

    public Student() {

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