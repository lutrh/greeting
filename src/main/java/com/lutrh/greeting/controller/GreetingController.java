package com.lutrh.greeting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "greetings")
public class GreetingController {

    @GetMapping("/{name}")
    public ResponseEntity<String> greetWithName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body("Hello " + name + "!");
    }

}
