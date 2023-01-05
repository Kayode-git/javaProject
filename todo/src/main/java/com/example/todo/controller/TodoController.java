package com.example.todo.controller;

import com.example.todo.dtos.TodoRequest;
import com.example.todo.model.Todo;


import java.util.List;

public interface TodoController {
    public String createNewTodo(TodoRequest request);
    public List<Todo> viewAllTodo();
    public Todo viewTodoById(String id);
    public String addToATodoAList(String id, TodoRequest request);
    public String deleteTodoById(String id);
}
