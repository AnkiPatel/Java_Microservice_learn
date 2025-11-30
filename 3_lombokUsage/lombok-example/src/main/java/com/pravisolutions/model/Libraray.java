package com.pravisolutions.model;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Libraray {

    @Autowired
    /*IMP NOTE: Student is prototype bean. but here it is singleton because
    for short duration it will create new instance. To get "every time new instance" clearly,
    we need to use object factory
     */
    //private Student student;
    private ObjectFactory<Student> studentFactory;

    public String getStudentName() {
        return studentFactory.getObject().getName();
    }
}
