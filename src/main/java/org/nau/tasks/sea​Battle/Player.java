package org.nau.tasks.sea​Battle;

import java.util.Scanner;

public class Player {
    public Board getBoard() {
        return board;
    }

    private Board board;

    public Player(Board board) {
        this.board = board;
    }

    public void placeShips() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("Встановлення " + (i + 1) + "-палубного корабля.");
            if (i == 0) {
                System.out.print("Введіть координати корабля (x y): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String result = board.positionTheShip(x, y);
                if (result.equals("Корабель встановлено")) {
                    System.out.println("Корабель успішно розположено.");
                } else {
                    System.out.println(result);
                    i--; // Повторить попытку установки однопалубного корабля
                }
            } else {
                while (true) {
                    System.out.print("Введіть координати корабля (x y): ");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    System.out.print("Введіть довжину корабля: ");
                    int length = scanner.nextInt();
                    System.out.print("Введіть направлення корабля (1 - угору, 2 - вправо, 3 - униз, 4 - вліво): ");
                    int direction = scanner.nextInt();
                    String result = board.positionTheShip(x, y, length, direction);
                    if (result.equals("Корабель встановлено")) {
                        System.out.println("Корабель успішно розположено.");
                        break;
                    } else {
                        System.out.println(result);
                    }
                }
            }
        }
    }

    public void makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сделайте выстрел (x y):");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.nextLine(); // consume newline
        String result = board.shoot(x, y);
        System.out.println(result);

        if (board.checkVictory()) {
            System.out.println("Поздравляем! Вы победили!");
        }
    }
}
