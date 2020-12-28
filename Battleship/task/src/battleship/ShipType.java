package battleship;

public enum ShipType {
    AircraftCarrier(5, "Aircraft Carrier"),
    BattleShip(4, "Battleship"),
    Submarine(3, "Submarine"),
    Cruiser(3, "Cruiser"),
    Destroyer(2, "Destroyer");

    int cells;
    String name;

    ShipType(int cells, String name) {
        this.cells = cells;
        this.name = name;
    }

    public int getCells() {
        return cells;
    }

    public String getName() {
        return name;
    }
}
