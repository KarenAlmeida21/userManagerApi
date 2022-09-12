package com.api.userManagerApi.controller;

import com.api.userManagerApi.Dtos.UserEntradaDto;
import com.api.userManagerApi.Dtos.UserFilterDto;
import com.api.userManagerApi.Dtos.UserSaidaDto;
import com.api.userManagerApi.models.User;
import com.api.userManagerApi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    UserService userService;


@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public void cadastrarUser(@RequestBody UserEntradaDto userEntradaDto){
    User userNew = modelMapper.map(userEntradaDto, User.class);
    modelMapper.map(userService.salvarUser(userNew),UserEntradaDto.class);
}


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUser(@PathVariable Long id) {
        userService.deletarUser(id);
    }

    @GetMapping("id/{id}")
    public UserSaidaDto exibirPorId(@PathVariable Long id) {
        User user = userService.exibirPorId(id);
        return modelMapper.map(user, UserSaidaDto.class);
    }

    @GetMapping("login/{login}")
    public UserSaidaDto exibirPorLogin(@PathVariable String login) {
        User user = userService.exibirPorLogin(login);
        return modelMapper.map(user, UserSaidaDto.class);
    }

    @PutMapping("/{login}")
    public UserFilterDto atualizarUser(@PathVariable String login,
                                       @RequestBody UserEntradaDto userEntradaDto) {
        User user = userService.atualizarUser(login, userEntradaDto);
        return modelMapper.map(user, UserFilterDto.class);
    }



}
