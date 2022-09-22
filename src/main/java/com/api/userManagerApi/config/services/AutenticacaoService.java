package com.api.userManagerApi.config.services;


import com.api.userManagerApi.models.User;
import com.api.userManagerApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
  private   UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(username);
        if (user.isPresent()) {

            return user.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");

    }
}
