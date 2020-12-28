package battleship;

public class Main {

    public static void main(String[] args) {

        GameBoard game = new GameBoard();

        ShipType[] ships = {
                ShipType.AircraftCarrier,
                ShipType.BattleShip,
                ShipType.Submarine,
                ShipType.Cruiser,
                ShipType.Destroyer
        };

        GameLoop gameLoop = new GameLoop(game, ships);
        gameLoop.Run();
    }


}
