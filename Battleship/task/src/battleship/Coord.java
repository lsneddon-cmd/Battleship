package battleship;

public class Coord {
    private int row;
    private int col;

    public Coord(String inputCoord) {
        // A is row 1 then sequentially to J = 10
        this.row = inputCoord.charAt(0) - 65; // ASCII Code of 'A', ensure uppercase passed
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
