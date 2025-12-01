package com.pravisolutions.repository;

import com.pravisolutions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    //-----------------------------------PART 1 ------------------------------------------------

    /*
    JPQL: Query language for entity objects. It doesn't support all SQL equivalent features.
    Though JpaRepository internally implement behaviour for entity class, if you still want to
    create behaviour, you can use @Query notation for transforming into equivalent ______________
     */

   /*
   @Query("SELECT u FROM User u")  //get all the user
   List<User> customGetUsers();

   @Query("SELECT u FROM User u WHERE u.email LIKE %:domain%")  // get all the user having asked string in email.
   List<User> customGetUsersQueryStr(@Param("domain") String domainStr);
   */


   //------------------------------------PART 2----------------------------------------------------
    // Handling complex SQL queries which is not possible with internal JPA implementation
    // we say that we are handling with "native" sql

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> customGetUsers();

    @Query(value = "SELECT * FROM user WHERE email LIKE %:domain%", nativeQuery = true)
    List<User> customGetUsersQueryStr(@Param("domain") String domain);






}
