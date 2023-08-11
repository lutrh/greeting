package com.lutrh.greeting.controller;

import com.lutrh.greeting.dto.StringManipulationRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
@RequestMapping(value = "strings")
public class StringController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> manipulate(@RequestBody StringManipulationRequest request) throws ReflectiveOperationException {
        Class<?> clazz = Class.forName(request.className());
        Method method = clazz.getDeclaredMethod(request.methodName(), String.class);
        Object result = method.invoke(null, request.input());
        return ResponseEntity.ok(result.toString());
    }

}

class StringCapitalizer {
    static String capitalize(String input) {
        return input.toUpperCase();
    }
}

class StringReverser {
    static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}


