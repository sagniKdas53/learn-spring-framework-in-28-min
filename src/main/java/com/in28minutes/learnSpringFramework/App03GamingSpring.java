package com.in28minutes.learnSpringFramework;

import com.in28minutes.learnSpringFramework.game.GameRunner;
import com.in28minutes.learnSpringFramework.game.GamingConsole;
import com.in28minutes.learnSpringFramework.game.MarioGame;
import com.in28minutes.learnSpringFramework.game.SuperContraGame;
import org.springframework.context.annotation.*;

import java.util.Arrays;

@Configuration
public class App03GamingSpring {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App03GamingSpring.class)) {
            var gameRunner0 = new GameRunner((GamingConsole) context.getBean("marioGame"));
            gameRunner0.run();

            // Using auto wiring
            var gameRunner1 = (GameRunner) context.getBean("gameRunner");
            gameRunner1.run();

            var gameRunner2 = (GameRunner) context.getBean("gameRunner2");
            gameRunner2.run();

            var gameRunner3 = (GameRunner) context.getBean("gameRunner3");
            gameRunner3.run();

            System.out.println("\nBeans loaded by Spring");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println();

            // This is autowiring the @Primary annotation so get the bean to run the up() method
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }

    @Bean
    public GamingConsole marioGame() {
        return new MarioGame();
    }

    @Bean
    @Primary
    public GamingConsole superContraGame() {
        return new SuperContraGame();
    }

//    @Bean
////    @Primary
//    public GamingConsole pacMan() {
//        return new PacMan();
//    }

    @Bean
    @Primary
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }

    @Bean
    public GameRunner gameRunner2() {
        return new GameRunner(new SuperContraGame());
    }

    @Bean
    public GameRunner gameRunner3() {
        return new GameRunner(new MarioGame());
    }
}
