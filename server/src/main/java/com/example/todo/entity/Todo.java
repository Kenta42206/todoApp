package com.example.todo.entity;

import java.sql.Timestamp;

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

    private String title;
    private boolean done;
    private Timestamp limitDate;

    // public Todo(String title, boolean done, Timestamp limitDate){
    //     this.title = title;
    //     this.done = false;
    //     this.limitDate = limitDate;
    // };

    public Todo(){};


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Timestamp getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Timestamp limitDate){
        this.limitDate = limitDate;
    }
}