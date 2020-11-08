package battleship;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        System.out.println("Printing board");
        game.printBoard();

        System.out.println("Creating a new Aircraft carrier");
        Ship carrier = new Ship(ShipType.AircraftCarrier);
        System.out.println("Ship type: " + carrier.getShip() + " of size: " + carrier.getCells());

        System.out.println("Checking space for ship in A1 to E1");
        Coord a1 = new Coord("A1");
        Coord e1 = new Coord("E1");
        System.out.println("Space for ship: " + game.spaceForShip(a1, e1));
        System.out.println("Coords are vertical: " + !Coord.areCoordsHorizontal(a1, e1));
        game.inputShipVertically(a1, e1);
        game.printBoard();
    }
}
