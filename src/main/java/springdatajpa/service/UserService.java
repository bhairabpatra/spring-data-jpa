package springdatajpa.service;

import springdatajpa.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    User createUser(User  user);

    List<User> getUsers();
}
