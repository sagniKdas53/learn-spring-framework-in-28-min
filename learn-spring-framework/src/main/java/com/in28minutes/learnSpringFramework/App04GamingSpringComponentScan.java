package com.in28minutes.learnSpringFramework;

import com.in28minutes.learnSpringFramework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnSpringFramework.game")
public class App04GamingSpringComponentScan {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App04GamingSpringComponentScan.class)) {
            // Finally, this was used here.
            context.getBean(GameRunner.class).run();
        }
    }

//    @Bean
//    public GameRunner gameRunner(GamingConsole gamingConsole) {
//        System.out.println("gamingConsole in bean: " + gamingConsole);
//        return new GameRunner(gamingConsole);
//    }
}
