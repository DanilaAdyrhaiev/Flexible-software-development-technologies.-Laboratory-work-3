package org.nau.entities;

import org.nau.abstractEntities.Animal;

public class Wolf extends Animal {
    public Wolf() {
        this("No name");
    }

    public Wolf(String name) {
        this(name, 1);
    }

    public Wolf(String name, int age) {
        this(name, age, Gender.MALE);
    }

    public Wolf(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public void makeSound() {
        System.out.println("Вовк виє");
    }

    @Override
    public void move() {
        System.out.println("Вовк біжить");
    }

    @Override
    public void eat() {
        System.out.println("Вовк їсть ");
    }
}
