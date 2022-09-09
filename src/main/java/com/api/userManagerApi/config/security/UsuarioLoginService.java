package com.api.userManagerApi.config.security;

import com.api.userManagerApi.models.User;
import com.api.userManagerApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioLoginService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> usuarioOptional = userRepository.findByLogin(login);

        usuarioOptional.orElseThrow(() ->  new UsernameNotFoundException("Dados incorretos"));
        User user = usuarioOptional.get();

        return new UserLogado(user.getId(), user.getLogin(), user.getPassword());
    }

}
