package battleship;

public class Coord {
    private int row;
    private int col;

    public Coord(String inputCoord) {
        // A is row 1 then sequentially to J = 10
        switch (inputCoord.charAt(0)) {
            case 'A':
                row = 1;
                break;
            case 'B':
                row = 2;
                break;
            case 'C':
                row = 3;
                break;
            case 'D':
                row = 4;
                break;
            case 'E':
                row = 5;
                break;
            case 'F':
                row = 6;
                break;
            case'G':
                row = 7;
                break;
            case 'H':
                row = 8;
                break;
            case 'I':
                row = 9;
                break;
            case 'J':
                row = 10;
                break;
            default:
                // Error case
                row = -1;
        }
        // 1 is row 2 then up in 2's until 20
        col = 2 * Integer.parseInt(String.valueOf(inputCoord.charAt(1)));
    }

    public static boolean isLengthCorrect(Coord start, Coord end, Ship ship) {
        if (start.getRow() == end.getRow()) {
            return Math.abs(start.getCol() - end.getCol()) == ship.getCells();
        }
        if (start.getCol() == end.getCol()) {
            return Math.abs(start.getRow() - end.getRow()) == ship.getCells();
        }
        return false;
    }

    public boolean isValidCoord() {
        return row != -1 || col < 1 || col > 10;
    }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
