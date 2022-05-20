import java.util.*;

public class User extends Player{


    @Override
    void move(GameBoard gameBoard, Round round) {
        if (round.equals(Round.X)) {
            System.out.println("Player 1:");
        } else {
            System.out.println("Player 2:");
        }
        System.out.println("Introdu linia si coloana(doua numere din intervalul[1,3], " +
                "cu un ' ' intre ele): ");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        boolean correctCommand = false;
        while(!correctCommand) {
            if (verifierCommand(command)){
                String[] array = command.split(" ");
                int coord1 = Integer.parseInt(array[0].trim());
                int coord2 = Integer.parseInt(array[1].trim());

                Cell cell = Cell.X;
                if (round.equals(Round.O)) {
                    cell = Cell.O;
                }


                if(gameBoard.playerMove(coord1, coord2, cell)) {
                correctCommand = true;
                } else {
                    System.out.println("Aceasta celula este ocupata! " +
                            "Introdu coordonate pentru o celula libera!");
                    command = scanner.nextLine();
                }
            } else {
                System.out.println("Coordonatele nu sunt corecte! " +
                        "Introdu coordonatele corecte: ");
                command = scanner.nextLine();
            }
        }


    }
    boolean verifierCommand(String comanda) {
        List<String> comenzi = List.of("1 1", "1 2", "1 3",
                                       "2 1", "2 2", "2 3",
                                       "3 1", "3 2", "3 3");
        return comenzi.contains(comanda);
    }
}
