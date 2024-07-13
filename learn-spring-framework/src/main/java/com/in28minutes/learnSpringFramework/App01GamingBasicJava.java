package com.in28minutes.learnSpringFramework;

import com.in28minutes.learnSpringFramework.game.GameRunner;
import com.in28minutes.learnSpringFramework.game.MarioGame;
import com.in28minutes.learnSpringFramework.game.PacMan;
import com.in28minutes.learnSpringFramework.game.SuperContraGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {
        var game1 = new MarioGame();
        var game2 = new SuperContraGame();
        var game3 = new PacMan();
        var gameRunner = new GameRunner(game3);
        gameRunner.run();
        new GameRunner(game1).run();
        new GameRunner(game2).run();
    }
}
