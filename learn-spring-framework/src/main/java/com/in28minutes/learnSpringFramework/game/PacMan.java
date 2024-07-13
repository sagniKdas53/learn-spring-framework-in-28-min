package com.in28minutes.learnSpringFramework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// This was auto-wired into GamerRunner
@Component
@Primary
public class PacMan implements GamingConsole {
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PacMan{ class: ");
        sb.append(PacMan.super.toString());
        sb.append(", methods: [up(), down(), left(), right()]");
        sb.append('}');
        return sb.toString();
    }

    public void up() {
        System.out.println("Hide");
    }

    public void down() {
        System.out.println("Run");
    }

    public void left() {
        System.out.println("Go back");
    }

    public void right() {
        System.out.println("Eat");
    }
}
