package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ToDoServiceTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    void getAllToDos(){
        ToDo todoSample = new ToDo("Todo Sample 1",true);
        toDoRepository.save(todoSample);
        ToDoService toDoService = new ToDoService(toDoRepository);

        ToDo firstResult = toDoService.findAll().get(0);

        assertEquals(todoSample.getText(), firstResult.getText());
        assertEquals(todoSample.isCompleted(), firstResult.isCompleted());
        assertEquals(todoSample.getId(), firstResult.getId());
    }

    @Test
    void addToDo(){
        ToDoService toDoService = new ToDoService(toDoRepository);
        ToDo newTodo = new ToDo(1L,"Eat thrice",true);
        ToDo saveTodo = toDoService.save(newTodo);

        assertEquals(newTodo.getText(), saveTodo.getText());
        assertEquals(newTodo.isCompleted(), saveTodo.isCompleted());
        assertEquals(newTodo.getId(), saveTodo.getId());
    }
}