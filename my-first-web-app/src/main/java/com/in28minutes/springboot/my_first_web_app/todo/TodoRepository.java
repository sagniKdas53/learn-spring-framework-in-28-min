package com.in28minutes.springboot.my_first_web_app.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findTodosByUsername(String username);

    Todo findFirstByIdNotNullOrderByIdDesc();

    Todo findTodoById(int id);
}
