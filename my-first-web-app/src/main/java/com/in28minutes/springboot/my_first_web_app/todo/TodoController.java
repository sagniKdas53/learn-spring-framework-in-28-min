package com.in28minutes.springboot.my_first_web_app.todo;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        log.info("todo: {}", todo);
        String todoDescription = todo.getDescription();
        boolean todoDone = todo.isDone();
        LocalDateTime targetDate = LocalDate.parse((CharSequence) todo.getTargetDate(), Todo.getDateTimeFormatter()).atStartOfDay();
        log.info("targetDate: {}", targetDate);
        if(result.hasErrors()) {
            model.addAttribute("error", "Invalid Todo Data. Please correct and submit again.");
            return "addTodo";
        }
        Priority priority = todo.getPriority();
        todoService.addTodo((String) model.get("name"), todoDescription, targetDate, todoDone, priority);
        return "redirect:list-todos";
    }

}
