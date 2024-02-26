package org.nau.tasks.sea​Battle;

import java.util.List;

public class Ship {
    private int length;

    private List<Coordinate> coordinates;
    int hp;

    public Ship(int length, List<Coordinate> coordinates){
        this.length = length;
        this.coordinates = coordinates;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void getDamage(){
        hp--;
    }

}
