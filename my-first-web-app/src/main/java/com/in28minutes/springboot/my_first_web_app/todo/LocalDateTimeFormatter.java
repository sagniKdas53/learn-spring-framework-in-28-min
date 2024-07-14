package com.in28minutes.springboot.my_first_web_app.todo;

import org.springframework.format.Formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDateTime parse(String text, Locale locale) {
        return LocalDateTime.parse(text, FORMATTER);
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return FORMATTER.format(object);
    }
}

