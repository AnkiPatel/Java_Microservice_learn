package com.pravisolutions.repository;

import com.pravisolutions.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository  //This is composite annotation which includes @Component annotation also.
// This will be singleton "component" (by default)
public class UserRepository {

    //For mocking under laying database
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User("kevin", "biden", "kb@ps.com"));
        this.users.add(new User("Ana", "Spacy", "ana@ps.com"));
        this.users.add(new User("Adam", "Joe", "aj@ps.com"));
        this.users.add(new User("John", "Ticker", "jt@ps.com"));
        this.users.add(new User("Micheal", "bush", "mb@ps.com"));
        this.users.add(new User("Neo", "Vanki", "nv@ps.com"));

        //this.users.add(User.builder().firstName("Aaradya").lastName("Pandit").email("ap@ps.com").build());
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User getUser(String id) {

        System.out.println("Check: " + id);
        /*int uIndex = (Integer.parseInt(id)) % 3; //HACK: Only because we have in-memory data for learning.
        System.out.println("check 2: " + uIndex);*/
        int uIndex = Integer.parseInt(id);
        return users.get(uIndex);
    }

    public boolean deleteUser(String id) {
        System.out.println("check: " + id);
        /*int uIndex = (Integer.parseInt(id)) % 3; //HACK: Only because we have in-memory data for learning.
        System.out.println("check 2: " + uIndex);*/
        int uIndex = Integer.parseInt(id);
        var us = users.remove(uIndex);
        System.out.println("Deleted user: " + us);
        return true;
    }

    public void updateUser(String id, User user) {
        int uIndex = Integer.parseInt(id);
        users.set(uIndex, user);
        System.out.println("updated user: " + user);
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }
}
