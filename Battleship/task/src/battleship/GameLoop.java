package battleship;

import java.util.Scanner;

public class GameLoop {
    private final Scanner scanner;
    private final GameBoard game;
    private final ShipType[] ships = {
            ShipType.AircraftCarrier,
            ShipType.BattleShip,
            ShipType.Submarine,
            ShipType.Cruiser,
            ShipType.Destroyer
    };
    private static GameLoop instance;

    private GameLoop(GameBoard game) {
        this.scanner = new Scanner(System.in);
        this.game = game;
    }

    public static GameLoop getInstance(GameBoard game) {
        if (instance == null) {
            instance = new GameLoop(game);
        }
        return instance;
    }

    public void Run() {
        game.printBoard();
        for (ShipType ship : ships) {
            System.out.println("Enter the coordinates of the " + ship.getName()
                    + " (" + ship.getCells() + " cells):");
            placeShipOnBoard(game, ship, scanner);
            game.printBoard();
        }


        System.out.println("The game starts!");
        game.printFogBoard();
        boolean won = false;
        while (!won) {
            System.out.println("Take a shot!");
            won = takeShot();
        }
        game.printBoard();
    }

    public static void placeShipOnBoard(GameBoard game, ShipType ship, Scanner sc) {
        boolean complete = false;
        String input;
        String[] inputArr;
        while (!complete) {
            input = sc.nextLine().toUpperCase();
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

    public boolean takeShot() {
        Coord shot = new Coord(scanner.nextLine().toUpperCase());
        if (shot.invalidCoord()) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return false;
        } else {
            if (game.board[shot.getRow()][shot.getCol()].equals("~")) {
                game.board[shot.getRow()][shot.getCol()] = "M";
                game.printFogBoard();
                System.out.println("You missed!");
            } else if (game.board[shot.getRow()][shot.getCol()].equals("O")) {
                game.board[shot.getRow()][shot.getCol()] = "X";
                game.printFogBoard();
                System.out.println("You hit a ship");
                establishShipHit(shot);
            } else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                return false;
            }
            // TODO check if a ship is sunk and print message for each new sunken ship
            // TODO check if all ships are sunk and return true
            if (ShipType.getSunkCount() == 5) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                return true;
            }
            return false;
        }
    }

    public void establishShipHit(Coord shot) {
        for (ShipType ship : ships) {
            if (ship.isHorizontal()) {
                if (shot.getCol() >= ship.getStart().getCol() && shot.getCol() <= ship.getEnd().getCol() && shot.getRow() == ship.getStart().getRow()) {
                    ship.hitCell();
                    if (ship.isSunk()) {
                        System.out.println("You sank a ship!");
                    }
                }
            } else {
                if (shot.getRow() >= ship.getStart().getRow() && shot.getRow() <= ship.getEnd().getRow() && shot.getCol() == ship.getStart().getCol()) {
                    ship.hitCell();
                    if (ship.isSunk()) {
                        System.out.println("You sank a ship!");
                    }
                }
            }
        }
    }
}
