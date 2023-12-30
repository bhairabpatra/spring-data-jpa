package springdatajpa.service;

import org.springframework.stereotype.Service;
import springdatajpa.model.User;
import springdatajpa.repositery.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    private  final  UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    ;
    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public User createUser(User user) {
       return userRepository.save(user);

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
