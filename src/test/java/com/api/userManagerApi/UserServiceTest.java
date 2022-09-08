package com.api.userManagerApi;

import com.api.userManagerApi.exceptions.UserInexistente;
import com.api.userManagerApi.models.User;
import com.api.userManagerApi.repositories.UserRepository;
import com.api.userManagerApi.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
@SpringBootTest
public class UserServiceTest {
    @MockBean
    private UserRepository userRepository;
    private User user;


    @Autowired
    private UserService userService;

    @BeforeEach
    private void user(){
        user = new User();
        user.setId(1L);
        user.setLogin("karen");
        user.setPassword("karen");;
    }
    @Test
    public void testeDeletarUserPositivo(){
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Mockito.doNothing().when(userRepository).deleteById(Mockito.anyLong());
        userRepository.deleteById(user.getId());
    }

}
