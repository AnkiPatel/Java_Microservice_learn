package com.pravisolutions.controller;

import com.pravisolutions.model.CreateUserRequest;
import com.pravisolutions.model.PatchUserRequest;
import com.pravisolutions.model.User;
import com.pravisolutions.serice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        String num = "2";
        int actualNum = Integer.parseInt(num);
        System.out.println(actualNum);
        return "Hello service user: at " + new Date().toString();
    }

    /*
    Here "id" and "name" are path variable
    Learning: If you don't define the path variable by API user then it will be exception.

    */
    @GetMapping("/test/{id}/{name}")
    public String test(@PathVariable("id") String someId,
                       @PathVariable("name") String someName) {

        return "Testing: at " + new Date().toString() + " id: " + someId + " name: " + someName;
    }

    /*
    Here "id" and "name" are path variable
    Learning: We are going to use "RequestParameter". This is powerful when we want to filter.
    here url will be like : http://localhost:8081/users/test2?page=5&name=Abhijit
    Still if API user don't pass the request param, it will be exception because by default it is "required".
    */
    @GetMapping("/test2")
    public String test2(@RequestParam("page") Integer page,
                       @RequestParam("name") String someName) {

        return "Testing: at " + new Date().toString() + " id: " + page + " name: " + someName;
    }

    /*
    Here "id" and "name" are path variable
    Learning: We are going to use "RequestParameter". This is powerful when we want to filter.
    here url will be like : http://localhost:8081/users/test3?page=5&name=Abhijit
    Now for API user has option whether he/she/it want to pass value for page and name.
    */
    @GetMapping("/test3")
    public String test3(@RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "name", required = false) String someName) {

        return "Testing: at " + new Date().toString() + " id: " + page + " name: " + someName;
    }

    @GetMapping
    public List<User> getUsers() {
        System.out.println("At getUsers");
        return userService.getUsers();
        //IMP NOTE: SpringBoot will transform this list representation with help of "Jackson" library
    }

    //Example : <base url>/users/2
    // Here '2' is path variable
    @GetMapping("/{EnteredId}")
    public User getUser(@PathVariable("EnteredId") String userId) {
        System.out.println("What user has given: " + userId);
        return userService.getUSer(userId);
    }

    @DeleteMapping("/{EnteredId}")
    public void deleteUser(@PathVariable("EnteredId") String userId){
        System.out.println("What user has given: " + userId);
        userService.deleteUser(userId);
    }

    @PatchMapping("/{EnteredId}")
    public void updateUSer(@PathVariable("EnteredId") String userId,
                           @RequestBody PatchUserRequest request) {
        //Here jackson will translate "request body content" which is in json into the object of "PatchUserReqest" class
        // NOTE: At this point, API user has to use field name in json according to class's variable name.
        // Example: user cannot define as first_name. Automatic conversion will give trouble.

        System.out.println(request);
        userService.updateUser(userId, request);

    }

    @PostMapping
    //Return : newly created user
    public User createUser(@RequestBody CreateUserRequest request) {
        System.out.println(request);
        return userService.createUser(request);
    }

}
