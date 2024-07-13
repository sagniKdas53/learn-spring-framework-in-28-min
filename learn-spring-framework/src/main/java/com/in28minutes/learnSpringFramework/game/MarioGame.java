package com.in28minutes.learnSpringFramework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole{
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MarioGame{");
        sb.append("class: ").append(MarioGame.super.toString());
        sb.append(", methods: [up(), down(), left(), right()]");
        sb.append('}');
        return sb.toString();
    }

    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("Go into a hole");
    }

    public void left() {
        System.out.println("Go back");
    }

    public void right() {
        System.out.println("Accelerate");
    }
}
