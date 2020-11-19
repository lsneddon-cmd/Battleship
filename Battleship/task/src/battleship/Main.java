package battleship;

public class Main {

    public static void main(String[] args) {

        GameBoard game = new GameBoard();

        Ship[] ships = {
                new Ship(ShipType.AircraftCarrier),
                new Ship(ShipType.BattleShip),
                new Ship(ShipType.Submarine),
                new Ship(ShipType.Cruiser),
                new Ship(ShipType.Destroyer)
        };

        GameLoop gameLoop = new GameLoop(game, ships);
        gameLoop.Run();
    }


}
