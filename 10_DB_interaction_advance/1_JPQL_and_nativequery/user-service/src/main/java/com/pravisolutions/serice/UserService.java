package com.pravisolutions.serice;

import com.pravisolutions.model.CreateUserRequest;
import com.pravisolutions.model.PatchUserRequest;
import com.pravisolutions.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();


    User getUser(String userId);

    void deleteUser(String id);
    void updateUser(String id, PatchUserRequest request);
    User createUser(CreateUserRequest request);

    // to learn jpql
    List<User> newWayGetAllUsers();
    List<User> newWayGetUsersQuery(String str);
}
