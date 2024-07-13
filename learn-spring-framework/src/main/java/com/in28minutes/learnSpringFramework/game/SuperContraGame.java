package com.in28minutes.learnSpringFramework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SuperContraGame{");
        sb.append("class: ").append(SuperContraGame.super.toString());
        sb.append(", methods: [up(), down(), left(), right()]");
        sb.append('}');
        return sb.toString();
    }

    public void up() {
        System.out.println("Up");
    }

    public void down() {
        System.out.println("Squat");
    }

    public void left() {
        System.out.println("Go back");
    }

    public void right() {
        System.out.println("Shoot");
    }
}
