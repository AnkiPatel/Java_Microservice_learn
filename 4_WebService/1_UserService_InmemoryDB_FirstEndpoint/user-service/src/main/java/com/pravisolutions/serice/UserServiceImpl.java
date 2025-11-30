package com.pravisolutions.serice;

import com.pravisolutions.model.User;
import com.pravisolutions.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //It is also composite annotation, having @Component annotation in built. For service layer component, user this annotation
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.getUsers();
    }
}
