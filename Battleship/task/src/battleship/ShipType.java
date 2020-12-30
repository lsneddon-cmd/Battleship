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
    private boolean isHorizontal;
    private int cellsHit;
    private Coord start;
    private Coord end;
    private static int sunkCount = 0;

    ShipType(int cells, String name) {
        this.cells = cells;
        this.name = name;
        this.isSunk = false;
        this.cellsHit = 0;
    }

    public static int getSunkCount() {
        return sunkCount;
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

    public void hitCell() {
        this.cellsHit++;
        this.isSunk = this.cellsHit == this.cells;
        if (isSunk) {
            sunkCount++;
        }
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public Coord getStart() {
        return start;
    }

    public void setStart(Coord start) {
        this.start = start;
    }

    public Coord getEnd() {
        return end;
    }

    public void setEnd(Coord end) {
        this.end = end;
    }
}
