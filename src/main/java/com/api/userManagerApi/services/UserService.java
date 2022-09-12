
package com.api.userManagerApi.services;

import com.api.userManagerApi.exceptions.UserExistente;
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

    public User salvarUser(User user) {
        if(userRepository.existsById(user.getId())){
            throw new UserExistente("Usuario já cadastrado");
        }else {
            userRepository.save(user);
            return user;
        }
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


    public User exibirPorLogin(String login){
        for(User user : userRepository.findAll()){
            if (user.getLogin().equals(login)) {

                return user;
            }
        }
        throw new UserInexistente("Login não encontrado");
    }


    public User atualizarUser(Long id, User userEntradaDto) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserInexistente("Não encontrado");
        } else {
            User userAtualiza = user.get();
            userAtualiza.setId(userEntradaDto.getId());
            userAtualiza.setLogin(userEntradaDto.getLogin());
            userAtualiza.setPassword(userEntradaDto.getPassword());
            userRepository.save(userAtualiza);
            return userAtualiza;
        }


    }
}
