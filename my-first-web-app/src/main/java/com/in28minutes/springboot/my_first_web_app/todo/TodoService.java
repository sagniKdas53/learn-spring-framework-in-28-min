package com.in28minutes.springboot.my_first_web_app.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class TodoService {

    private final TodoRepository todos;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todos = todoRepository;
    }

    public List<Todo> retrieveTodos(String username) {
        log.info("retrieveTodos - username: {}", username);
        return todos.findTodosByUsername(username);
        //return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done, Priority priority) {
        log.info("addTodo - username: {}, description: {}, targetDate: {}, done: {}, priority: {}", username, description, targetDate, done, priority);
        int highestId = todos.findByIdOrderByIdDesc().getId(); //todos.stream().mapToInt(Todo::getId).max().orElse(username);
        log.info("highestId: {}", highestId);
        Todo todo = new Todo(++highestId, username, description, targetDate, done, priority);
        log.info("Added Todo - id: {}, name: {}, description: {}, targetDate: {}, done: {}, priority: {}", todo.getId(), todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone(), todo.getPriority());
        todos.save(todo);
    }

    public void deleteTodoByIdWrapper(int id) {
        todos.deleteById(id);
        //todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo retrieveTodoById(int id) {
        return todos.getTodoById(id);
        //return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(new Todo());
    }

    public void updateTodo(int id, String name, String todoDescription, LocalDate targetDate, boolean todoDone, Priority priority) {
        log.debug("Updated Todo - id: {}, name: {}, description: {}, targetDate: {}, done: {}, priority: {}", id, name, todoDescription, targetDate, todoDone, priority);
        Todo todo = retrieveTodoById(id);
        todo.setUsername(name);
        todo.setDescription(todoDescription);
        todo.setTargetDate(targetDate);
        todo.setDone(todoDone);
        todo.setPriority(priority);
        todos.save(todo);
    }
}
