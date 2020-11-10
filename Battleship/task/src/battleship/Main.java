package battleship;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameBoard game = new GameBoard();
        game.printBoard();

        Ship[] ships = {
                new Ship(ShipType.AircraftCarrier),
                new Ship(ShipType.BattleShip),
                new Ship(ShipType.Submarine),
                new Ship(ShipType.Cruiser),
                new Ship(ShipType.Destroyer)
        };

        for (int ship = 0; ship < ships.length; ship++) {
            System.out.println("Enter the coordinates for the " + ships[ship].getShip()
            + " (" + ships[ship].getCells() + " cells):");
            placeShipOnBoard(game, ships[ship], scanner);
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
            complete = game.inputShip(new Coord(inputArr[0]), new Coord(inputArr[1]), ship);
        }
    }
}
