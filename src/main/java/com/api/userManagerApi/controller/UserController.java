package com.api.userManagerApi.controller;

import com.api.userManagerApi.Dtos.UserEntradaDto;
import com.api.userManagerApi.Dtos.UserFilterDto;
import com.api.userManagerApi.Dtos.UserSaidaDto;
import com.api.userManagerApi.Dtos.UserSave;
import com.api.userManagerApi.models.User;
import com.api.userManagerApi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CacheEvict(value ="exibirUsers", allEntries = true)
    public void cadastrarUser(@RequestBody @Valid UserSave userEntradaDto) {
        User userNew = modelMapper.map(userEntradaDto, User.class);
        modelMapper.map(userService.salvarUser(userNew), UserSave.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value ="exibirUsers", allEntries = true)
    public void deletarUser(@PathVariable Long id) {
        userService.deletarUser(id);
    }

    @Cacheable(value = "exibirPorId")
    @GetMapping("id/{id}")
    public UserSaidaDto exibirPorId(@PathVariable Long id) {
        User user = userService.exibirPorId(id);
        return modelMapper.map(user, UserSaidaDto.class);
    }

    @Cacheable(value = "exibirPorLogin")
    @GetMapping("login/{login}")
    public UserSaidaDto exibirPorLogin(@PathVariable String login) {
        User user = userService.exibirPorLogin(login);
        return modelMapper.map(user, UserSaidaDto.class);
    }

    @Cacheable(value = "exibirUsers")
    @GetMapping("exibirUserList")
    public List<UserSaidaDto> exibirUserList() {
        List<UserSaidaDto> userList = new ArrayList<>();
        for (User userReferencia : userService.exibirUsers()) {
            UserSaidaDto userSaidaDto = modelMapper.map(userReferencia, UserSaidaDto.class);
            userList.add(userSaidaDto);
        }
        return userList;
    }


    @PatchMapping("/{login}")
    @CacheEvict(value ="exibirUsers", allEntries = true)
    public UserFilterDto atualizarUser(@PathVariable String login,
                                       @RequestBody UserEntradaDto userEntradaDto) {
        User user = userService.atualizarUser(login, userEntradaDto);
        return modelMapper.map(user, UserFilterDto.class);
    }


}
