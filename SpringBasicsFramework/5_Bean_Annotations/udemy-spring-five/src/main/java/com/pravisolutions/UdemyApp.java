package com.pravisolutions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UdemyApp {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        Student s1 = (Student) context.getBean("student_bean");
        s1.sayHello();
        System.out.println("StudentBean has been created with name: " + s1.getStudentName());

        //NOTE: With dependency injection, Application writer/coder don't need to explicitly instantiate the object
        // which is dependency
        s1.showInfo();
    }
}
