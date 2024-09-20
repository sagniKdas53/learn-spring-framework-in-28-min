package com.in28minutes.springboot.my_first_web_app.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


@Slf4j
@Getter
@Setter
@Component
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(
            min = 10,
            message = "Enter at least 10 characters"
    )
    private String description;
    @FutureOrPresent
    private LocalDate targetDate;
    private boolean done;
    private Priority priority;

    public static DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Override
    public String toString() {
        return "Todo{" + "description='" + description + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                ", priority=" + priority +
                '}';
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

    public Todo(int id, String username, String description, LocalDate targetDate, boolean done, Priority priority) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
        this.priority = priority;
    }
}
