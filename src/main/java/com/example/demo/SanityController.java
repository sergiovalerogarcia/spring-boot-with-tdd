package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SanityController {

    @GetMapping("/")
    ResponseEntity<String> getAllToDos() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}