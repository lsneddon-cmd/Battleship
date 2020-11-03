package battleship;

public class Ship {
    private ShipType ship;
    private int cells;

    public Ship(ShipType typeOfShip) {
        ship = typeOfShip;
        switch (ship) {
            case AircraftCarrier:
                cells = 5;
                break;
            case BattleShip:
                cells = 4;
                break;
            case Submarine:
            case Cruiser:
                cells = 3;
                break;
            case Destroyer:
                cells = 2;
                break;
            default:
                cells = 0;
        }
    }

    public int getCells() { return cells; }
    public ShipType getShip() { return ship; }

}
