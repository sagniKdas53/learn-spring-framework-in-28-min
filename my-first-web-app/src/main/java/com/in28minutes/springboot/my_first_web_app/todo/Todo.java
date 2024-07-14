package com.in28minutes.springboot.my_first_web_app.todo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


@Slf4j
@Getter
@Setter
@Component
public class Todo {
    private int id;
    private String username;
    private String description;
    private LocalDateTime targetDate;
    private boolean done;
    private Priority priority;

    public static DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Todo{");
        sb.append("description='").append(description).append('\'');
        sb.append(", id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", targetDate=").append(targetDate);
        sb.append(", done=").append(done);
        sb.append(", priority=").append(priority);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id && done == todo.done && Objects.equals(username, todo.username) && Objects.equals(description, todo.description) && Objects.equals(targetDate, todo.targetDate) && priority == todo.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, description, targetDate, done, priority);
    }

    public Todo() {
    }

    public Todo(int id, String username, String description, LocalDateTime targetDate, boolean done, Priority priority) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
        this.priority = priority;
    }
}
