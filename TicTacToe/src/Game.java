
import java.util.Scanner;

public class Game {
    GameBoard gameboard = new GameBoard();
    Round round = Round.X;
    Player player1;
    Player player2;


    void getInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdu numarul de jucatori(1 sau 2). Daca selectezi 1 " +
                "vei juca cu calculatorul, daca selectezi 2, este nevoie de doi jucatori");
        String cuvant = scanner.nextLine();

        boolean nrPayersSelected = false;
        while (!nrPayersSelected) {
            switch (cuvant) {
                case "1" -> {
                    setPlayers(1);
                    nrPayersSelected = true;

                }
                case "2" -> {
                    setPlayers(2);
                    nrPayersSelected = true;

                }
                default -> {
                    System.out.println("Numarul nu este valid! Introdu un numar(1 sau 2): ");
                    cuvant = scanner.nextLine();
                }
            }
        }

    }

     void start() {
        gameboard.init();
        gameboard.print();
        getInfo();
        while(true) {
            player1.move(gameboard, round);
            changeRound();
            gameboard.print();
            if(gameOver()) {
                break;
            }
            player2.move(gameboard, round);
            changeRound();
            gameboard.print();
            if(gameOver()) {
                break;
            }
        }
         System.out.println("Jocul s-a terminat");
     }

     private void changeRound() {
        if (round.equals(Round.X)) {
            round = Round.O;
            System.out.println("Mutare Player1");
        } else {
            round = Round.X;
            System.out.println("Mutare Player2");
        }
     }

     void setPlayers(int nrPlayers) {
        player1 = new User();
        if(nrPlayers == 1) {
            player2 = new Computer();
        } else {
            player2 = new User();
        }

     }

     boolean gameOver() {
        if (gameboard.getGameState().equals(GameState.X_WIN)) {
            System.out.println("X a castigat");
            return true;
        }
        if (gameboard.getGameState().equals(GameState.O_WIN)) {
            System.out.println("O a castigat");
            return true;
        }
        if (gameboard.getGameState().equals(GameState.DRAW)) {
            System.out.println("Remiza");
            return true;
        }
        return false;
     }
}
