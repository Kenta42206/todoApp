package com.example.todo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;







@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todo")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
        Todo todo = todoService.getTodoById(id).orElseThrow(()->new RuntimeException("Todoが見つかりません"));
        return ResponseEntity.ok(todo);
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo newTodo = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }


    @PutMapping("/todo/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
    
    
    
}
