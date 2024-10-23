package com.example.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.todo.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long>{};