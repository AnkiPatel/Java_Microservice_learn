package com.pravisolutions.controller;

import com.pravisolutions.model.CreateUserRequest;
import com.pravisolutions.model.PatchUserRequest;
import com.pravisolutions.model.User;
import com.pravisolutions.serice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/testheader")
    public String headercheck(@RequestHeader HttpHeaders header) {
        String returnStr = "";
        String clientHostname = header.getHost().getHostName();
        int clientPortname = header.getHost().getPort();

        returnStr =  "Header check: at " + new Date().toString() +
                "\nHostname: " + clientHostname + " Port: " + clientPortname;
        return returnStr;
    }

    @GetMapping("/testheaderwithdata")
    public String headerchecktwo(@RequestHeader("client_data") String somedata,
                                 @RequestHeader(value = "metadata", required = true) int somenum,
                                 @RequestHeader(value = "counter_data", defaultValue = "10") int counterdata) {
        // metadata will be compulsory parameter in the header. API user has to provide
        String returnStr = "";
        System.out.println("client_data: " + somedata);
        System.out.println("metadata: " + somenum);
        System.out.println("counter_data: " + counterdata);

        returnStr =  "Header with data check: at " + new Date().toString();
        return returnStr;
    }

    @GetMapping("/testheadernext")
    public String headercheckthree(@RequestHeader Map<String, String> headers) {
        // With this, API  user can inject as many parameter as needed in http header
        headers.forEach((String key, String val)-> {
            System.out.println("Key: " + key + " Value: " + val);
        });

        return "Header with data check: at " + new Date().toString();
    }

    @GetMapping
    public List<User> getUsers() {
        System.out.println("At getUsers");
        return userService.getUsers();
        //IMP NOTE: SpringBoot will transform this list representation with help of "Jackson" library
    }

    //Example : <base url>/users/2
    // Here '2' is path variable
    // Also demonstration of "ResponseEntity"
    @GetMapping("/{EnteredId}")
    public ResponseEntity<User> getUser(@PathVariable("EnteredId") String userId) {
        System.out.println("What user has given: " + userId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("custome-header", "This is a hash code usually");

        //When you dont need to pass the header
        //return new ResponseEntity<>(userService.getUSer(userId), (HttpHeaders) null, HttpStatus.OK);

        //Another way to provide response.
        //return ResponseEntity.ok(userService.getUSer(userId));

        //NOTE: It is advisable to user "ResponseEntity" for whole response
        return new ResponseEntity<>(userService.getUSer(userId), headers, HttpStatus.OK);


    }

    @DeleteMapping("/{EnteredId}")
    public void deleteUser(@PathVariable("EnteredId") String userId){
        System.out.println("What user has given: " + userId);
        userService.deleteUser(userId);
    }

    @PatchMapping("/{EnteredId}")
    public void updateUSer(@PathVariable("EnteredId") String userId,
                           @RequestBody PatchUserRequest request) {
        // IMP: PatchUserRequest is called DTO (Data transfer object). We dont use "User" class here which is entity for
        // Database operations.

        //Here jackson will translate "request body content" which is in json into the object of "PatchUserReqest" class
        // NOTE: At this point, API user has to use field name in json according to class's variable name.
        // Example: user cannot define as first_name. Automatic conversion will give trouble.

        System.out.println(request);
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
