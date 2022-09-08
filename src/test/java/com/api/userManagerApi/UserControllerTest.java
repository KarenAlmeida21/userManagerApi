package com.api.userManagerApi;

import com.api.userManagerApi.Dtos.UserEntradaDto;
import com.api.userManagerApi.Dtos.UserSaidaDto;
import com.api.userManagerApi.componentes.Conversor;
import com.api.userManagerApi.controller.UserController;
import com.api.userManagerApi.models.User;
import com.api.userManagerApi.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({UserServiceTest.class, UserController.class, Conversor.class})
public class UserControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private User user;
    private UserEntradaDto userEntradaDto;
    private UserSaidaDto userSaidaDto;

    @BeforeEach
    public void user(){
        user=new User();
        user.setId(1L);
        user.setLogin("karen");
        user.setPassword("karen1");

        userEntradaDto = new UserEntradaDto();
        userEntradaDto.setId(1L);
        userEntradaDto.setLogin("karen");
        userEntradaDto.setPassword("karen1");

        userSaidaDto = new UserSaidaDto();
        userSaidaDto.setId(1L);
        userSaidaDto.setLogin("karen");

        objectMapper = new ObjectMapper();
    }
}
