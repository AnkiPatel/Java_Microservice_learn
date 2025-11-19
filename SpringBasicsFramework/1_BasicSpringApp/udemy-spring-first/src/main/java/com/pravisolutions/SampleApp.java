package com.pravisolutions;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleApp {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        //The ioc container
        // ClassPathXmlApplicationContext is the concrete implementation of the IoC container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        //Now student bean has been already created. We also provided the value of student name in spring-beans.xml
        Student s = (Student)context.getBean("student_bean");
        s.sayHello();
    }
}