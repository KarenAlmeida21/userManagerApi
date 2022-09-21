package com.api.userManagerApi.config;

import com.api.userManagerApi.exceptions.UserInexistente;
import com.api.userManagerApi.models.User;
import com.api.userManagerApi.repositories.UserRepository;
import com.api.userManagerApi.repositories.UserRepositorySecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    UserRepositorySecurity userRepositorySecurity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepositorySecurity.findByLogin(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserInexistente("Dados inválidos");

    }
}
