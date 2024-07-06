package com.in28minutes.learnSpringFramework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// This got scanned and registered as a bean in the Spring container
@Component
public class GameRunner {

    GamingConsole game;

    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.printf("\nRunning %s%n", game.toString());
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
