package com.in28minutes.springboot.my_first_web_app.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 3;

    static {
        todos.add(new Todo(1, "guactimusprime", "Learn Spring Boot", LocalDate.now().plusMonths(1), false, Priority.HIGH));
        todos.add(new Todo(2, "in28minutes", "Learn Azure 900", LocalDate.now().plusMonths(3), false, Priority.MEDIUM));
        todos.add(new Todo(3, "guactimusprime", "Learn Kubernetes", LocalDate.now().plusMonths(6), false, Priority.LOW));
    }

    public List<Todo> retrieveTodos(String username) {
        log.info("retrieveTodos - username: {}", username);
        return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done, Priority priority) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done, priority);
        log.info("Added Todo - id: {}, name: {}, description: {}, targetDate: {}, done: {}, priority: {}", todo.getId(), todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone(), todo.getPriority());
        todos.add(todo);
    }

    public void deleteTodoById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo retrieveTodoById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(new Todo());
    }

    public void updateTodo(int id, String name, String todoDescription, LocalDate targetDate, boolean todoDone, Priority priority) {
        log.debug("Updated Todo - id: {}, name: {}, description: {}, targetDate: {}, done: {}, priority: {}", id, name, todoDescription, targetDate, todoDone, priority);
        Todo todo = retrieveTodoById(id);
        todo.setUsername(name);
        todo.setDescription(todoDescription);
        todo.setTargetDate(targetDate);
        todo.setDone(todoDone);
        todo.setPriority(priority);
    }
}