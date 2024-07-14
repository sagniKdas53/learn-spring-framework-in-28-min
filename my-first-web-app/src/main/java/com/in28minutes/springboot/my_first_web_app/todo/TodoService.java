package com.in28minutes.springboot.my_first_web_app.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 3;

    static {
        todos.add(new Todo(1, "in28minutes", "Learn Spring Boot", LocalDateTime.now().plusMonths(1), false, Priority.HIGH));
        todos.add(new Todo(2, "in28minutes", "Learn Azure 900", LocalDateTime.now().plusMonths(3), false, Priority.MEDIUM));
        todos.add(new Todo(3, "in28minutes", "Learn Kubernetes", LocalDateTime.now().plusMonths(6), false, Priority.LOW));
    }

    public List<Todo> retrieveTodos(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDateTime targetDate, boolean done, Priority priority) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done, priority);
        todos.add(todo);
    }
}
