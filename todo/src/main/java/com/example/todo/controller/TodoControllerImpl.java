package com.example.todo.controller;

import com.example.todo.dtos.TodoRequest;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todo")
public class TodoControllerImpl implements TodoController {
    @Autowired
    TodoServiceImpl service;
    @PostMapping("/new")
    public String createNewTodo(@RequestBody TodoRequest request) {
       service.addTodo(request);
       return "Done!!!";
    }

    @GetMapping("/view/all")
    public List<Todo> viewAllTodo() {
        return service.viewAll();
    }

    @GetMapping("/view/{todoId}")
    public Todo viewTodoById(@PathVariable("todoId") String id) {
        return service.viewById(id);
    }

    @PostMapping("/add/{todoId}")
    public String addToATodoAList(@PathVariable("todoId") String id,
                                  @RequestBody TodoRequest request) {
        service.addToTodo(id, request);
        return "Added";
    }

    @DeleteMapping("/delete/{todoId}")
    public String deleteTodoById(@PathVariable("todoId") String id) {
        service.deleteById(id);
        return "Deleted";
    }

}
