package com.supermarket.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @RequestMapping(value = "/saludo", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld (){
        return "Welcome";
    }
}
