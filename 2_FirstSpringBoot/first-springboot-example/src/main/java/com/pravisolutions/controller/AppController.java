package com.pravisolutions.controller;

import com.pravisolutions.model.Libraray;
import com.pravisolutions.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Specialized version of @Controler to create RESTful web services
//A convenience annotation that is itself annotated with @Controller and @ResponseBody.
@RestController

@RequestMapping("/testapp") // Base URL for all mappings
public class AppController {

    @Autowired
    private Student student;

    @Autowired
    private Libraray scienceLibraray;

    @GetMapping("/luser")
    public void getLibraryUser() throws InterruptedException {

        /*
        IMPNOTE: This method is important to understand behaviour of the prototype scoped bean.
        If you don't use ObjectFactory in Library class for student dependency,
        then framework will create only one instance of the student, inspite of declaring student also as prototype bean.

        ObjectFactory allows you to obtain a bean on demand rather than at container startup, and
        is especially useful when dealing with prototype-scoped beans, circular dependencies, or
        when you don't want Spring to inject the actual instance immediately
        * */
        System.out.println( scienceLibraray.getStudentName());
        Thread.sleep(5000);
        System.out.println(scienceLibraray.getStudentName());
    }

    @GetMapping
    public String greet() {
        return "Hello App user";
    }

    @GetMapping("/student")
    public String getStudent() {
        return student.toString();
    }
}
