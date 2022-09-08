package services;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.Optional;

@Service
public class userService {
@Autowired
    UserRepository userRepository;

    public Object salvarUser(User user) {
        return userRepository.save(user);
    }
    public void deletarUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserInexistente("Login Inexistente");
        }
        userRepository.deleteById(id);
    }
}
