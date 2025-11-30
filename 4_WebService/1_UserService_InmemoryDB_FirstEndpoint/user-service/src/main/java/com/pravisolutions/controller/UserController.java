package com.pravisolutions.controller;

import com.pravisolutions.model.User;
import com.pravisolutions.serice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController //This will also include the "ResponseBody" annotation which trigger json serialization by using jackson library
@RequestMapping("/users") // Base URL for all mappings. NOTE "/" is optional, but it is more intuitive for code reader, hence we are doing.
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //@RequestMapping(value="/hello", method = RequestMethod.GET)
    // You can achieve above annotation with this too. this endpoint is just for demo purpose
    @GetMapping("/hello")
    public String hello() {

        return "Hello service user: at " + new Date().toString();
    }

    @GetMapping
    public List<User> getUsers() {
        System.out.println("At getUsers");
        return userService.getUsers();
        //IMP NOTE: SpringBoot will transform this list representation with help of "Jackson" library
    }
}
