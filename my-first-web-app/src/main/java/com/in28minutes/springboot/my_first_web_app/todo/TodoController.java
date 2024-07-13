package com.in28minutes.springboot.my_first_web_app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

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

//    @RequestMapping("favicon.ico")
//    public String favicon() {
//        return "forward:static/favicon.ico";
//    }

}
