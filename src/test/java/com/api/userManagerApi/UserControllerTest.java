package com.api.userManagerApi;

import com.api.userManagerApi.Dtos.UserEntradaDto;
import com.api.userManagerApi.Dtos.UserSaidaDto;
import com.api.userManagerApi.componentes.Conversor;
import com.api.userManagerApi.controller.UserController;
import com.api.userManagerApi.exceptions.UserInexistente;
import com.api.userManagerApi.models.User;
import com.api.userManagerApi.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
        user= new User();
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

    @Test
    public void testarDeleteUser()throws Exception{
        user.setId(Long.valueOf(1));
        Mockito.doNothing().when(userService).deletarUser(Mockito.anyLong());
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.delete("/user/"
                + user.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(204));
    }

    @Test
    public void testeDeleteUserNegativo() throws Exception {
        Mockito.doThrow(UserInexistente.class).when(userService).deletarUser(Mockito.anyLong());

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.delete("/user/" +
                        user.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(422));
    }

}
