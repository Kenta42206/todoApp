package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todo) {
        Todo targetTodo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        targetTodo.setTitle(todo.getTitle());
        targetTodo.setDone(todo.isDone());
        return todoRepository.save(targetTodo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}