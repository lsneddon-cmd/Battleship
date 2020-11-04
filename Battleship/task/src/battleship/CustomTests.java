package battleship;

public class CustomTests {
    public static void runTestOne() {
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

        System.out.println("Re-checking space for ship function returns false when no space");
        System.out.print("Expect False: ");
        System.out.println(game.spaceForShip(firstCoord, secondCoord));

        System.out.println("Try putting Destroyer horizontally A3 - A4");
        Coord dStart = new Coord("A3");
        Coord dEnd = new Coord("A4");
        Ship dShip = new Ship(ShipType.Destroyer);
        System.out.println("Checking ship size");
        System.out.print("Expect 2: ");
        System.out.println(dShip.getCells());
    }
}
