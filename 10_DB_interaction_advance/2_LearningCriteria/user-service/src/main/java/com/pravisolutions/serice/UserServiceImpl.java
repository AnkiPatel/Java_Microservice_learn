package com.pravisolutions.serice;

import com.pravisolutions.model.CreateUserRequest;
import com.pravisolutions.model.PatchUserRequest;
import com.pravisolutions.model.User;
import com.pravisolutions.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    /*
    A) About @PersistenceContext
    This persistence context annotation is used to inject an instance of entitymanager into a spring component.
    This annotation tells the spring container to provide a properly managed entitymanager that is thread safe,
    and it is scoped to the current transaction or context. So essentially, the injected Entitymanager is
    automatically associated with the actual transaction,and there is no need to manage opening and closing
    connections manually. it enables us to create criteria related code.
    */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public List<User> getUserSpecificName() {

        //NOTE: With "Criteria", we dont need JPA ...................

        CriteriaBuilder builder = entityManager.getCriteriaBuilder(); //This is the entry point for building criteria based queries in a type safe and object oriented manner.

        // Below is "SELECT"
        CriteriaQuery<User> query = builder.createQuery(User.class); // this is how we declare that this select query will produce a list of users when executed.
        // we can now filter with WHERE and FILTER
        // SELECT u FROM User u
        Root<User> root = query.from(User.class); //Root represents a reference to the entity in the query.
        /*So think of Root<User> as the "main table" in your SQL FROM clause, and "root" as alias you're going to use in the rest of the query*/
        root.get("firstName");  // with the help of this root we can have access to the first name, last name, email and all the field variables of that entity.

        //WHERE with Predicates
        /* the predicate always represents a boolean valued expression.
        * It is used to represent conditions typically in the where having or join parts of the query.
        * It answers the question does this row or entity match the condition?
        * */
        Predicate firstNamePredicate = builder.equal(root.get("firstName"), "Miraj");
        query.where(firstNamePredicate);

        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public List<User> newWayGetAllUsers() {
        return repository.customGetUsers();
    }

    @Override
    public List<User> newWayGetUsersQuery(String str) {
        return repository.customGetUsersQueryStr(str);
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
