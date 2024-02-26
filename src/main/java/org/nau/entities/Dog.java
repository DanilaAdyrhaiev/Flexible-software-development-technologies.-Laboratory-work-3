package org.nau.entities;

import lombok.Getter;
import org.nau.abstractEntities.Animal;

@Getter
public class Dog extends Animal {
    public Dog(){
        this("No name");
    }
    public Dog(String name){
        this(name, 1);
    }
    public Dog(String name, int age){
        this(name, age, Gender.MALE);
    }

    public Dog(String name, int age, Gender gender){
        this.age = age;
        this.name = name;
        this.gender=gender;
    }

    @Override
    public void makeSound() {
        System.out.println("Собака гавкає");
    }

    @Override
    public void move() {
        System.out.println("Собака йде");
    }

    @Override
    public void eat() {
        System.out.println("Собака їсть");
    }

    @Override
    public String toString() {
        return "Собака: " + name + "; Стать: "+gender +"; Вік "+age;
    }
}
