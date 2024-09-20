package com.in28minutes.springboot.my_first_web_app.todo;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

    private final TodoService todoService;

    private final TodoRepository todoRepository;

    @Autowired
    public TodoControllerJPA(TodoService todoService, TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
        this.todoService = todoService;
    }

    @GetMapping("list-todos")
    public String showTodosList(ModelMap model) {
        List<Todo> todos = todoRepository.findTodosByUsername(getLoggedInUserName());
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    private static String getLoggedInUserName() {
        SecurityContext securityContextHolder = SecurityContextHolder.getContext();
        return securityContextHolder.getAuthentication().getName();
    }

    @GetMapping("add-todo")
    public String addTodo(ModelMap model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @PostMapping(path = "add-todo", consumes = "application/x-www-form-urlencoded")
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Invalid Todo Data. Please correct and submit again.");
            return "addTodo";
        }
        String username = getLoggedInUserName();
        int todoHighestCount = todoRepository.findFirstByIdNotNullOrderByIdDesc().getId();
        todo.setId(++todoHighestCount);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String updateTodoGet(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findTodoById(id);
        log.debug("updateTodoGet: todo: {}", todo);
        model.addAttribute("id", id);
        model.addAttribute("todo", todo);
        return "updateTodo";
    }

    @PostMapping(path = "update-todo", consumes = "application/x-www-form-urlencoded")
    public String updateTodoPost(ModelMap model, @Valid Todo todo, BindingResult result) {
        log.debug("updateTodoPost: todo: {}", todo);
        if (result.hasErrors()) {
            model.addAttribute("error", "Invalid Todo Data. Please correct and submit again.");
            return "update-todo";
        }
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

}
