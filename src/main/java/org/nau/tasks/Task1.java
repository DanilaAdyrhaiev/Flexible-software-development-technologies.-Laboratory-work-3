package org.nau.tasks;

import org.nau.entities.Dog;
import org.nau.services.AnimalService;
import org.nau.services.WineService;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalService animalService = new AnimalService();
        System.out.println("Введіть назву тварини: ");
        animalService.add(new Dog(scanner.nextLine()));


    }
}
