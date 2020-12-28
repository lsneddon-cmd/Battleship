package battleship;

public enum ShipType {
    AircraftCarrier(5, "Aircraft Carrier"),
    BattleShip(4, "Battleship"),
    Submarine(3, "Submarine"),
    Cruiser(3, "Cruiser"),
    Destroyer(2, "Destroyer");

    private final int cells;
    private final String name;
    private boolean isSunk;

    ShipType(int cells, String name) {
        this.cells = cells;
        this.name = name;
        this.isSunk = false;
    }

    public int getCells() {
        return cells;
    }

    public String getName() {
        return name;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }
}
