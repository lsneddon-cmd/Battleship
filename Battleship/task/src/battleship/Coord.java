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
        if (inputCoord.length() == 3) {
            if (Integer.parseInt(String.valueOf(inputCoord.charAt(2))) == 0) {
                col = 9;
            } else {
                col = -1;
            }
        } else {
            col = Integer.parseInt(String.valueOf(inputCoord.charAt(1))) - 1;
        }

    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean invalidCoord() {
        return row < 0 || row > 9 || col < 0 || col > 9;
    }
}
