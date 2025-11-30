package com.pravisolutions.serice;

import com.pravisolutions.model.CreateUserRequest;
import com.pravisolutions.model.PatchUserRequest;
import com.pravisolutions.model.User;
import com.pravisolutions.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service //It is also composite annotation, having @Component annotation in built. For service layer component, user this annotation
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.getUsers();
    }

    @Override
    public User getUSer(String id) {
        return repository.getUser(id);
    }

    @Override
    public void deleteUser(String id) {
       if(repository.deleteUser(id))
           System.out.println("Successfully deleted the user");
       else
           System.out.println("Could not delete the user");
    }

    @Override
    public void updateUser(String id, PatchUserRequest request) {
        var user = repository.getUser(id);
        if(request.getFirstName() != null) {
            user.setFirstName(request.getFirstName());
        }

        if(request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }

        if(request.getLastName() != null) {
            user.setLastName(request.getLastName());
        }
        repository.updateUser(id, user);
    }

    @Override
    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setCreated(new Date());

        return repository.createUser(user);
    }
}
