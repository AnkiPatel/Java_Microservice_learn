package com.pravisolutions.serice;

import com.pravisolutions.model.CreateUserRequest;
import com.pravisolutions.model.PatchUserRequest;
import com.pravisolutions.model.User;
import com.pravisolutions.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    //With Stream API
    @Override
    public User getUser(String userId) {
        // whether a User with userId is present in the DB
        // Stream API
        User user =  Optional.of(userId)
                .map(Long::valueOf)
                .flatMap(repository::findById)
                .orElseThrow();
        return user;
    }

    //How to implement without stream API
    /*@Override
    public User getUser(String userId) {

        Long luserId = Long.valueOf(userId);
        Optional<User> result = repository.findById(luserId);

        if(result.get() == null) {
            throw new RuntimeException();
        }
        return result.get();
    }*/

    @Override
    public void deleteUser(String userId) {
        Optional.of(userId)
                .map(Long::valueOf)
                .flatMap(repository::findById)
                .orElseThrow();

        // CODE BLOCK A
        Optional.of(userId)
                .map(Long::valueOf)
                .ifPresent(repository::deleteById);
        // you can use following also instead of CODE BLOCK A
        // repository.deleteById(Long.valueOf(userId));
    }

    @Override
    public void updateUser(String id, PatchUserRequest request) {

        System.out.println(request);
        var user = this.getUser(id);
        if(request.getFirstName() != null) {
            user.setFirstName(request.getFirstName());
        }

        if(request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }

        if(request.getLastName() != null) {
            user.setLastName(request.getLastName());
        }
        repository.save(user);
    }

    @Override
    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        return repository.save(user);
    }
}
