package com.pravisolutions.repository;

import com.pravisolutions.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository  //This is composite annotation which includes @Component annotation also.
// This will be singleton "component" (by default)
public class UserRepository {

    //For mocking under laying data base
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User("kevin", "biden", "kb@ps.com"));
        this.users.add(new User("Ana", "Spacy", "ana@ps.com"));
        this.users.add(new User("Adam", "Joe", "aj@ps.com"));

        //this.users.add(User.builder().firstName("Aaradya").lastName("Pandit").email("ap@ps.com").build());
    }

    public List<User> getUsers() {
        return this.users;
    }

}
