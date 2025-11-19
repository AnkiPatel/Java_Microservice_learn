package com.pravisolutions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UdemyApp {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        Student s1 = (Student)context.getBean("student_bean");
        s1.sayHello();
        System.out.println("StudentBean has been created with name: " + s1.getStudentName() );

        /*
        NOTE: when we define init and destroy method of the bean, we can leverage the chance to do specific operations
        during initialization of the bean and destruction of bean.

        Destroy will not get call until we close the context.
        Now ApplicationContext doesnt have method to get close so we type case into ConfigurableApplicationContext

        MIMP: Destory method will get called for singleton beans but NOT FOR prototype scoped beans
        TO AVOID MEMORY LEAK

        */

        ((ConfigurableApplicationContext) context).close();

        /************** Usage of prototype bean*******************/
        /*ClassDetail cd1 = (ClassDetail) context.getBean("classdetail_bean");
        System.out.println(cd1.getClassID());

        //Here context will give totally different object because type of bean is prototype
        ClassDetail cd2 = (ClassDetail) context.getBean("classdetail_bean");
        cd2.setClassID("2B");

        System.out.println("cd1: " + cd1);
        System.out.println("cd2: " + cd2);

        System.out.println();*/
    }

    /*
    OP:
    ----
    Init: Student obj
    Eva Purohit says hello from spring framework
    StudentBean has been created with name: Eva Purohit
    destroy: Student obj
    * */
}