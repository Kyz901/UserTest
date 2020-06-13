package com.testtask.userLibrary.controller;


import com.testtask.userLibrary.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/user")

public class UserController {
    @GetMapping("/user")
    public String getUserByName(@RequestParam String name){
        return name;
    }
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id) {
        return "test" + id;
    }
    @PostMapping("/user")
    public void setUser(@RequestBody UserDto user){
        log.info(user.toString());
    }



}
