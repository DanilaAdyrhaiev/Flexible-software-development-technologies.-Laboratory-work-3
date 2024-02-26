package org.nau.tasks.sea​Battle;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private char[][] field;

    public List<Ship> getShips() {
        return ships;
    }

    private List<Ship> ships;

    public Board() {
        field = new char[10][10];
        ships = new ArrayList<>();
        fillWithZeros();
    }

    private void fillWithZeros() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = '0';
            }
        }
    }

    public String positionTheShip(int x, int y){
        int startX = x-1;
        int startY = y-1;
        if (startX >= 0 && startX <= 10 && startY >= 0 && startY <= 10 && field[startX][startY] != '1') {
            field[y - 1][x - 1] = '1';
            List<Coordinate> coords = new ArrayList<>();
            coords.add(new Coordinate(startX, startY));
            ships.add(new Ship(1, coords));
            return "Корабель встановлено";
        }
        return "Неможливо встановити корабель";
    }

    public String positionTheShip(int x, int y, int length, int direction){
        int startX = x - 1;
        int startY = y - 1;

        if (field[startY][startX] != '1' && (0 < x && x < 11) && (0 < y && y < 11)) {
            switch (direction) {
                case 1: // up
                    int endY = startY - length;
                    List<Coordinate> coordsUp = new ArrayList<>();
                    if (endY >= 0) {
                        for (int i = startY; i >= endY; i--) {
                            if (field[i][startX] == '1') {
                                return "Неможливо встановити корабель";
                            }
                            field[i][startX] = '1';
                            coordsUp.add(new Coordinate(startX, i));
                        }
                        ships.add(new Ship(length, coordsUp));
                        return "Корабель встановлено";
                    }
                    break;
                case 2: // right
                    int endXRight = startX + length;
                    List<Coordinate> coordsRight = new ArrayList<>();
                    if (endXRight < 10) {
                        for (int i = startX; i < endXRight; i++) {
                            if (field[startY][i] == '1') {
                                return "Неможливо встановити корабель";
                            }
                            field[startY][i] = '1';
                            coordsRight.add(new Coordinate(i, startY));
                        }
                        ships.add(new Ship(length, coordsRight));
                        return "Корабель встановлено";
                    }
                    break;
                case 3: // down
                    int endYDown = startY + length;
                    List<Coordinate> coordsDown = new ArrayList<>();
                    if (endYDown < 10) {
                        for (int i = startY; i < endYDown; i++) {
                            if (field[i][startX] == '1') {
                                return "Неможливо встановити корабель";
                            }
                            field[i][startX] = '1';
                            coordsDown.add(new Coordinate(startX, i));
                        }
                        ships.add(new Ship(length, coordsDown));
                        return "Корабель встановлено";
                    }
                    break;
                case 4: // left
                    int endXLeft = startX - length;
                    List<Coordinate> coordsLeft = new ArrayList<>();
                    if (endXLeft >= 0) {
                        for (int i = startX; i >= endXLeft; i--) {
                            if (field[startY][i] == '1') {
                                return "Неможливо встановити корабель";
                            }
                            field[startY][i] = '1';
                            coordsLeft.add(new Coordinate(i, startY));
                        }
                        ships.add(new Ship(length, coordsLeft));
                        return "Корабель встановлено";
                    }
                    break;
                default:
                    return "Неправильное направление";
            }
        }
        return "Неможливо встановити корабель";
    }

    public String shoot(int x, int y){
        int X = x - 1;
        int Y = y - 1;
        if (field[Y][X] == '1') {
            for (Ship ship : ships) {
                for (Coordinate coordinate : ship.getCoordinates()) {
                    if (coordinate.getX() == X && coordinate.getY() == Y) {
                        ship.getDamage();
                        if (ship.hp == 0) {
                            for (Coordinate coord : ship.getCoordinates()) {
                                field[coord.getY()][coord.getX()] = 'X';
                            }
                            ships.remove(ship);
                        } else {
                            field[Y][X] = 'X';
                        }
                        if (ships.isEmpty()) {
                            return "Перемога! Всі кораблі противника знищені.";
                        }
                        return "Попадання! Ворожий корабель пошкоджений.";
                    }
                }
            }
        } else {
            field[Y][X] = '-';
            return "Промах!";
        }
        return "";
    }

    public boolean checkVictory() {
        return ships.isEmpty();
    }

}
