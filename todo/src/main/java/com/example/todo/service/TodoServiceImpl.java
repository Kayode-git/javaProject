package com.example.todo.service;

import com.example.todo.dtos.TodoRequest;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    TodoRepository repository;
    public void addTodo(TodoRequest request) {
        Todo todo = new Todo(request.getBody());
        repository.save(todo);
    }

    public List<Todo> viewAll() {
        return repository.findAll();
    }

    public Todo viewById(String id) {
        Optional<Todo> todo = repository.findById(id);

        if (todo.isEmpty()) {
            throw new IllegalArgumentException("todo with id"+ id + "cannot be found");
        }
        return todo.get();
    }

    public void addToTodo(String id, TodoRequest request) {
        Optional<Todo> todo = repository.findById(id);
        if (todo.isEmpty()) {
            throw new IllegalArgumentException("todo with id"+ id + "cannot be found");
        }
        String body = todo.get().getBody();
        body += "\n"+ request.getBody();
        todo.get().setBody(body);
        repository.save(todo.get());

    }

    public void deleteById(String id) {
        Optional<Todo> todo = repository.findById(id);
        if (todo.isEmpty()) {
            throw new IllegalArgumentException("todo with id"+ id + "cannot be found");
        }
        repository.deleteById(id);
    }
}
