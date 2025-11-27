package com.pravisolutions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UdemyApp {
    public static void main(String[] args) {

        //The ioc container
        // ClassPathXmlApplicationContext is the concrete implementation of the IoC container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        //Now student bean has been already created. We also provided the value of student name in spring-beans.xml
        Student s1 = (Student)context.getBean("student_bean");
        s1.sayHello();
        System.out.println("StudentBean has been created with name: " + s1.getStudentName() );

        // Because our bean is singleton, everytime we will get the same object through context
        Student s2 = (Student)context.getBean("student_bean");
        System.out.println("Student S2 has name: " + s2.getStudentName() );

        //Validating if we are gettin same object or not
        System.out.println(s1 == s2); //OP: true



        /************** Usage of prototype bean*******************/
        ClassDetail cd1 = (ClassDetail) context.getBean("classdetail_bean");
        System.out.println(cd1.getClassID());

        //Here context will give totally different object because type of bean is prototype
        ClassDetail cd2 = (ClassDetail) context.getBean("classdetail_bean");
        cd2.setClassID("2B");

        System.out.println("cd1: " + cd1);
        System.out.println("cd2: " + cd2);

        System.out.println();

    }
}