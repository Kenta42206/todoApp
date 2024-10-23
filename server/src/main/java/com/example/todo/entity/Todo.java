package com.example.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String todo_name;

    public Todo(String todo_name){
        this.todo_name = todo_name;
    }

    public Long getId(){
        return id;
    }

    public String getTodoName(){
        return todo_name;
    }
}