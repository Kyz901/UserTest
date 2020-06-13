package com.testtask.userLibrary.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping("/ping")
    public void ping() {
        log.info("test");
    }
}
