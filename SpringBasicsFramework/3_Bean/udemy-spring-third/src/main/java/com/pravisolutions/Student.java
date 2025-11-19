package com.pravisolutions;

public class Student {
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void sayHello() {
        System.out.println(this.studentName + " says hello from spring framework");
    }


    public void initStudentBean() {
        System.out.println("Init: Student obj");
    }

    public void destroyStudentBean() {
        System.out.println("destroy: Student obj");
    }
}
