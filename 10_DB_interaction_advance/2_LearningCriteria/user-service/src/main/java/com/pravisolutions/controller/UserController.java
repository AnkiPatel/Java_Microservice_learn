package com.pravisolutions.controller;

import com.pravisolutions.model.CreateUserRequest;
import com.pravisolutions.model.PatchUserRequest;
import com.pravisolutions.model.User;
import com.pravisolutions.serice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/hello")
    public String hello() {
        String num = "2";
        int actualNum = Integer.parseInt(num);
        System.out.println(actualNum);
        return "Hello service user: at " + new Date().toString();
    }

    @GetMapping("/new/usermiraj")
    public ResponseEntity<List<User>> newwayGetAllUsersSpecificName() {
        System.out.println("At get user miraj");
        return ResponseEntity.ok(userService.getUserSpecificName());

    }

    @GetMapping("/new/alluser")
    public ResponseEntity<List<User>> newwayGetAllUsers() {
        System.out.println("At getUsers");
        return ResponseEntity.ok(userService.newWayGetAllUsers());

    }

    @GetMapping("/new/selectedUser/{EmailStr}")
    public ResponseEntity<List<User>> newwayGetAllUsers(@PathVariable("EmailStr") String emailStr) {
        System.out.println("Ankita: check");
        return ResponseEntity.ok(userService.newWayGetUsersQuery(emailStr));

    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        System.out.println("At getUsers");
        return ResponseEntity.ok(userService.getUsers());

    }


    @GetMapping("/{EnteredId}")
    public ResponseEntity<User> getUser(@PathVariable("EnteredId") String userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @DeleteMapping("/{EnteredId}")
    public void deleteUser(@PathVariable("EnteredId") String userId){
        System.out.println("What user has given: " + userId);
        userService.deleteUser(userId);
    }

    @PatchMapping("/{userid}")
    public void updateUSer(@PathVariable("userid") String userId,
                           @RequestBody PatchUserRequest request) {
        System.out.println("update user: ");
        userService.updateUser(userId, request);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Return : newly created user
    // IMP: CreateUserRequest is called DTO (Data transfer object). We dont use "User" class here which is entity for
    // Database operations.

    // NOTE: If create request is successfull, we need to put http response code as 201
    public User createUser(@RequestBody CreateUserRequest request) {
        System.out.println(request);
        return userService.createUser(request);
    }

}
