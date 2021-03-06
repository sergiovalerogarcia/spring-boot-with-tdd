package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todos")
    ResponseEntity<List<ToDo>> getAllToDos() {
        return new ResponseEntity<>(toDoService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/todos/add")
    ResponseEntity<ToDo> saveToDo(@RequestBody ToDo todo) {
        return new ResponseEntity<>(toDoService.save(todo), HttpStatus.CREATED);
    }

    @DeleteMapping("/todos/delete/{id}")
    ResponseEntity deleteToDo(@PathVariable Long id) {
        if (toDoService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}