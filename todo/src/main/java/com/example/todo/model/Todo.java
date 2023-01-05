package com.example.todo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
public class Todo {
    @Id
    private String id;
    private LocalDateTime dayWritten;
    private String body;

    public Todo(String body) {
        this.dayWritten = LocalDateTime.now();
        this.body = body;
    }
}
