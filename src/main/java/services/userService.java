package services;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

@Service
public class userService {
@Autowired
    UserRepository userRepository;

    public Object salvarUser(User user) {
        return userRepository.save(user);
    }
}