package com.in28minutes.learnSpringFramework.examples.dataBase;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySQL implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
