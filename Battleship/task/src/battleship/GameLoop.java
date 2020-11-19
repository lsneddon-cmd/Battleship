package battleship;

import java.util.Scanner;

public class GameLoop {
    private Scanner scanner;
    private GameBoard game;
    private Ship[] ships;

    public GameLoop(GameBoard game, Ship[] ships) {
        this.scanner = new Scanner(System.in);
        this.game = game;
        this.ships = ships;
    }

    public void Run() {
        for (Ship ship : ships) {
            System.out.println("Enter the coordinates of the " + ship.getShipAsString()
                    + " (" + ship.getCells() + " cells):");
            placeShipOnBoard(game, ship, scanner);
            game.printBoard();
        }


        System.out.println("The game starts!");
        game.printFogBoard();
        boolean won = false;
        while (!won) {
            System.out.println("Take a shot!");
            won = takeShot(game, scanner);
        }
        game.printBoard();
    }

    public static void placeShipOnBoard(GameBoard game, Ship ship, Scanner sc) {
        boolean complete = false;
        String input;
        String[] inputArr;
        while (!complete) {
            input = sc.nextLine();
            inputArr = input.split(" ");
            Coord start = new Coord(inputArr[0]);
            Coord end = new Coord(inputArr[1]);
            if (GameBoard.doCoordsAscend(start, end)) {
                complete = game.inputShip(start, end, ship);
            } else {
                complete = game.inputShip(end, start, ship);
            }

        }
    }

    public static boolean takeShot(GameBoard game, Scanner sc) {
        String input = sc.nextLine();
        Coord shot = new Coord(input);
        if (shot.invalidCoord()) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return false;
        } else {
            if (game.board[shot.getRow()][shot.getCol()].equals("~")) {
                game.board[shot.getRow()][shot.getCol()] = "M";
                game.printBoard();
                System.out.println("You missed!");
            } else if (game.board[shot.getRow()][shot.getCol()].equals("O")) {
                game.board[shot.getRow()][shot.getCol()] = "X";
                game.printBoard();
                System.out.println("You hit a ship");
            } else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                return false;
            }
            // TODO check if a ship is sunk and print message for each new sunken ship
            // TODO check if all ships are sunk and return true
            return true;
        }
    }
}
