package springdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdatajpa.dto.UserDto;
import springdatajpa.mapper.UserMapper;
import springdatajpa.model.User;
import springdatajpa.repositery.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    private  final  UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return userMapper.mapToUserDto(user.get());
    }

    @Override
    public UserDto createUser(UserDto  userDto) {
        User user = userMapper.mapToUserEntity(userDto);
       return userMapper.mapToUserDto(userRepository.save(user));

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
