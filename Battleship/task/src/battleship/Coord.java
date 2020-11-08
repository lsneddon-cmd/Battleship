package battleship;

public class Coord {
    private int row;
    private int col;

    public Coord(String inputCoord) {
        // A is row 1 then sequentially to J = 10
        switch (inputCoord.charAt(0)) {
            case 'A':
                row = 0;
                break;
            case 'B':
                row = 1;
                break;
            case 'C':
                row = 2;
                break;
            case 'D':
                row = 3;
                break;
            case 'E':
                row = 4;
                break;
            case 'F':
                row = 5;
                break;
            case'G':
                row = 6;
                break;
            case 'H':
                row = 7;
                break;
            case 'I':
                row = 8;
                break;
            case 'J':
                row = 9;
                break;
            default:
                // Error case
                row = -1;
        }
        col = Integer.parseInt(String.valueOf(inputCoord.charAt(1)));
    }

    public static boolean isLengthCorrect(Coord start, Coord end, Ship ship) {
        if (areCoordsHorizontal(start, end)) {
            return Math.abs(start.getCol() - end.getCol()) == ship.getCells();
        } else {
            return Math.abs(start.getRow() - end.getRow()) == ship.getCells();
        }
    }

    public static boolean areCoordsHorizontal(Coord start, Coord end) {
        return start.getRow() == end.getRow();
    }

    public static boolean doCoordsAscend(Coord start, Coord end) {
        if (areCoordsHorizontal(start, end)) {
            return start.getCol() < end.getCol();
        } else {
            return start.getRow() < end.getRow();
        }
    }

    public boolean isValidCoord() {
        return row != -1 && col > 1 && col < 10;
    }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
