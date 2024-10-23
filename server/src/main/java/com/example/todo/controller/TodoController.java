package com.example.todo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.repository.TodoRepository;



@RestController
public class TodoController {

    private final TodoRepository repository;


    public TodoController(TodoRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    public String todo() {
        return String.valueOf(repository.findAll());
    }
    
    
}
