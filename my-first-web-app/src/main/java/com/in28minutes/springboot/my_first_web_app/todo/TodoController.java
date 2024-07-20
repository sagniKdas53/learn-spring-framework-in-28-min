package com.in28minutes.springboot.my_first_web_app.todo;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @GetMapping("list-todos")
    public String showTodosList(ModelMap model) {
        List<Todo> todos = todoService.retrieveTodos("in28minutes");
        //model.put("name", model.get("name"));
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String addTodo(ModelMap model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @PostMapping(path = "add-todo", consumes = "application/x-www-form-urlencoded")
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        String todoDescription = todo.getDescription();
        boolean todoDone = todo.isDone();
        LocalDate targetDate = todo.getTargetDate();
        String username = (String) model.get("name");
        if (result.hasErrors()) {
            model.addAttribute("error", "Invalid Todo Data. Please correct and submit again.");
            return "addTodo";
        }
        Priority priority = todo.getPriority();
        todoService.addTodo(username, todoDescription, targetDate, todoDone, priority);
        return "redirect:list-todos";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodoById(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String updateTodoGet(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.retrieveTodoById(id);
        log.debug("updateTodoGet: todo: {}", todo);
        model.addAttribute("id", id);
        model.addAttribute("todo", todo);
        return "updateTodo";
    }

    @PostMapping(path = "update-todo", consumes = "application/x-www-form-urlencoded")
    public String updateTodoPost(ModelMap model, @Valid Todo todo, BindingResult result) {
        log.debug("updateTodoPost: todo: {}", todo);
        int id = todo.getId();
        String todoDescription = todo.getDescription();
        String username = todo.getUsername();
        boolean todoDone = todo.isDone();
        LocalDate targetDate = todo.getTargetDate();
        //LocalDate.parse((CharSequence) todo.getTargetDate(), Todo.getDateTimeFormatter()).atStartOfDay();
        if (result.hasErrors()) {
            model.addAttribute("error", "Invalid Todo Data. Please correct and submit again.");
            return "update-todo";
        }
        Priority priority = todo.getPriority();
        todoService.updateTodo(id, username, todoDescription, targetDate, todoDone, priority);
        return "redirect:list-todos";
    }

}
