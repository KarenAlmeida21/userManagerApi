
package com.api.userManagerApi.services;

import com.api.userManagerApi.exceptions.UserInexistente;
import com.api.userManagerApi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.userManagerApi.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
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
    public User exibirPorId(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserInexistente("Usuario não encontrado");
        }
        User userGet = user.get();
        return userGet;
    }

}
