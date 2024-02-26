package org.nau.services;

import org.nau.abstractEntities.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {
    private List<Animal> animals = new ArrayList<>();
    private long nextId = 1;

    public Animal add(Animal animal){
        animal.setId(nextId);
        animals.add(animal);
        nextId++;
        return animal;
    }

    public List<Animal> listAll(){
        return animals;
    }

    public Animal update(Animal animal){
        for(int i = 0; i < animals.size(); i++){
            Animal animalToCheck = animals.get(i);
            if(animalToCheck.getId() == animal.getId()){
                animals.set(i, animal);
                return animal;
            }
        }
        return null;
    }

    public Animal getByParam(long id){
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public Animal getByParam(String name){
        for (Animal animal : animals){
            if(animal.getName().equals(name)){
                return animal;
            }
        }
        return null;
    }

    public void displayAllAnimals(){
        for(Animal animal : animals){
            System.out.println(animal.toString());
        }
    }
}
