package com.in28minutes.springboot.my_first_web_app.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findTodosByUsername(String username);

    Todo getTodoById(int id);

    @Query("select count(t) from Todo t where upper(t.username) = upper(?1)")
    long countByUsernameIgnoreCase(String username);

    @Override
    void deleteById(Integer integer);

    @Query("select t from Todo t order by t.id DESC limit 1")
    Todo findByIdOrderByIdDesc();
}
