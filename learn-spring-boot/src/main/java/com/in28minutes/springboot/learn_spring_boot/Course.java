package com.in28minutes.springboot.learn_spring_boot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private int id;
    private String name;
    private String author;
    private String description;

    public Course(int id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course [" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", author='" + author + '\'' +
               ", description='" + description + '\'' +
               ']';
    }


}
