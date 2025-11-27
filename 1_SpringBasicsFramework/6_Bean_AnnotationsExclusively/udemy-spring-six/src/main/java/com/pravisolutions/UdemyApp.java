package com.pravisolutions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UdemyApp {
    public static void main(String[] args) {

        // For using "AppConfiguration", we cannot use ClassPathXmlApplicationContext
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Student s1 = (Student) context.getBean("student_bean");
        s1.setStudentName("Eva Purohit");
        s1.sayHello();
        s1.showInfo();

        Student s2 = (Student) context.getBean("student_bean");
        s2.setStudentName("Geeta Kumar");
        s2.sayHello();
        s2.showInfo();

        System.out.println(s1 == s2); //false

        //NOTE: With dependency injection, Application writer/coder don't need to explicitly instantiate the object
        // which is dependency
        s1.showInfo();
    }
}
