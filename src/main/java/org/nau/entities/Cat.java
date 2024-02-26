package org.nau.entities;

import org.nau.abstractEntities.Animal;

public class Cat extends Animal {
    public Cat() {
        this("No name");
    }

    public Cat(String name) {
        this(name, 1);
    }

    public Cat(String name, int age) {
        this(name, age, Gender.FEMALE);
    }

    public Cat(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public void makeSound() {
        System.out.println("Кіт муркоче");
    }

    @Override
    public void move() {
        System.out.println("Кіт стрибає");
    }

    @Override
    public void eat() {
        System.out.println("Кіт їсть ");
    }
}
