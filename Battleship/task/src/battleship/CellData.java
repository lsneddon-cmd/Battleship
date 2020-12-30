package battleship;

public enum CellData {
    FOG("~"),
    MISSED("M"),
    SHIP("O"),
    HIT("X");

    private String display;

    CellData(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
