package org.nau.tasks.sea​Battle;

public class Game {
    private Player player1;
    private Player player2;
    private boolean gameOver;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameOver = false;
    }

    public void start() {
        System.out.println("Игра началась!");
        player1.placeShips();
        player2.placeShips();

        while (!gameOver) {
            player1.makeMove();
            if (checkVictory()) break;
            player2.makeMove();
            if (checkVictory()) break;
        }
    }

    private boolean checkVictory() {
        if (player1.getBoard().getShips().isEmpty()) {
            System.out.println("Игрок 2 победил! Все корабли игрока 1 потоплены.");
            gameOver = true;
            return true;
        } else if (player2.getBoard().getShips().isEmpty()) {
            System.out.println("Игрок 1 победил! Все корабли игрока 2 потоплены.");
            gameOver = true;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Board board1 = new Board();
        Board board2 = new Board();
        Player player1 = new Player(board1);
        Player player2 = new Player(board2);
        Game game = new Game(player1, player2);
        game.start();
    }
}
