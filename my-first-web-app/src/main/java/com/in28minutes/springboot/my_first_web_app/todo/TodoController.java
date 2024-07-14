package com.in28minutes.springboot.my_first_web_app.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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

    @RequestMapping("list-todos")
    public String showTodosList(ModelMap model) {
        List<Todo> todos = todoService.retrieveTodos("in28minutes");
        //model.put("name", model.get("name"));
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String addTodo(ModelMap model) {
        model.addAttribute("todo", new Todo(0, (String) model.get("name"), "",
                LocalDateTime.now().plusMonths(1), false, Priority.LOW));
        return "addTodo";
    }

    @PostMapping(path = "add-todo", consumes = "application/x-www-form-urlencoded")
    public String addTodo(ModelMap model, Todo todo) {
        String desc = todo.getDescription();
        boolean done = todo.isDone();
        todoService.addTodo((String) model.get("name"), desc, LocalDateTime.now().plusMonths(1), done, Priority.MEDIUM);
        return "redirect:list-todos";
    }

}
