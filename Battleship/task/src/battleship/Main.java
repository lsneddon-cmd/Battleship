package battleship;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameBoard game = new GameBoard();

        Ship[] ships = {
                new Ship(ShipType.AircraftCarrier),
                new Ship(ShipType.BattleShip),
                new Ship(ShipType.Submarine),
                new Ship(ShipType.Cruiser),
                new Ship(ShipType.Destroyer)
        };

        for (Ship ship : ships) {
            System.out.println("Enter the coordinates of the " + ship.getShipAsString()
                    + " (" + ship.getCells() + " cells):");
            placeShipOnBoard(game, ship, scanner);
            game.printBoard();
        }
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
}
