package com.testtask.userLibrary.controller;


import com.testtask.userLibrary.dto.UserDto;
import com.testtask.userLibrary.model.User;
import com.testtask.userLibrary.service.UserServise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServise userService;

    @GetMapping("/user")
    public String getUserFullName(@RequestParam Long id){

        return userService.getUserFullName(id);
    }

    @GetMapping("/user/all")
    public List<UserDto> getAllUser(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        return mapperFactory.getMapperFacade().mapAsList(userService.getAllUsers(),UserDto.class);
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        return mapperFactory.getMapperFacade().map(userService.getUserById(id),UserDto.class);
    }


    @PostMapping("/user")
    public void setUser(@RequestBody UserDto user){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        userService.saveUser(mapperFactory.getMapperFacade().map(user, User.class));
    }

    @PutMapping("/user")
    public void updateUser(@RequestParam Long id,
                           @RequestParam String firstName,
                           @RequestParam String secondName){

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        User user = userService.getUserById(id);
        userService.updateUser(mapperFactory.getMapperFacade().map(user, User.class),firstName,secondName);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Long id){

        return  userService.delete(id);
    }
}
