package com.example.todo.service;

import com.example.todo.dtos.TodoRequest;
import com.example.todo.model.Todo;

import java.util.List;

public interface TodoService {
    public void addTodo(TodoRequest request);
    public List<Todo> viewAll();
    public Todo viewById(String id);
    public void addToTodo(String id, TodoRequest request);
    public void deleteById(String id);
}
