package com.pravisolutions.repository;

import com.pravisolutions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*
    1) Since this interface is extending JpaRepository, no need to explicitly mention @Repository annotation
    2) JpaRepository<User, Long>: With this Springboot automatically implements behavioral regarding "User"
    i.e deletebyid , findbyid etc. check the JpaRepository class
    */

    //Since field name in "User" class is "firstName", equivalent method name will be <Task>FirstName
    //User findByFirstName(String firstName); //Internally spring boot will automatically create implementation for this method
    //User findByLastName(String lastName);



}
