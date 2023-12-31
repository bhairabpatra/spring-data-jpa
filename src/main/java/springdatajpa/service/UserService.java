package springdatajpa.service;

import springdatajpa.dto.UserDto;
import springdatajpa.model.User;

import java.util.List;

public interface UserService {
    UserDto getUser(Long id);

    UserDto createUser(UserDto userDto);

    List<User> getUsers();
}
