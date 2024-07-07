package com.in28minutes.learnSpringFramework.examples.dataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Primary
@Qualifier("mongoDBFindMaxService")
public class FindMaxService {
    private final DataService dataService;

    @Autowired
    public FindMaxService(DataService ds) {
        this.dataService = ds;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
