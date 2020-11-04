package battleship;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        GameBoard game = new GameBoard();
        game.printBoard();

        Coord firstCoord = new Coord("A1");
        Coord secondCoord = new Coord("D1");

        System.out.println("Checking Coords valid");
        System.out.println(firstCoord.isValidCoord());
        System.out.println(secondCoord.isValidCoord());

        System.out.println("Checking Coords are vertical");
        System.out.println(!Coord.areCoordsHorizontal(firstCoord, secondCoord));

        System.out.println("Checking Coords are correct size for Battleship");
        System.out.println(Coord.isLengthCorrect(firstCoord, secondCoord, new Ship(ShipType.BattleShip)));

        System.out.println("Checking Coords are in ascending order");
        System.out.println(Coord.doCoordsAscend(firstCoord, secondCoord));

        System.out.println("Checking space for ship function");
        System.out.println(game.spaceForShip(firstCoord, secondCoord));

        System.out.println("Checking input ship vertically");
        System.out.println(game.inputShipVertically(firstCoord, secondCoord));

        System.out.println("Printing updated game board");
        game.printBoard();
    }
}
