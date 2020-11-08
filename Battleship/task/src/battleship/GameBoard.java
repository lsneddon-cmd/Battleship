package battleship;

public class GameBoard {
    String[][] board = new String[10][10];

    public GameBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "~";
            }
        }
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 1; i < 21; i++) {
            if (i % 2 != 0) {
                System.out.print(String.valueOf((i / 2) + 1));
            } else {
                System.out.print(' ');
            }
        }
        System.out.println();
        for (int i = 1; i < 11; i++) {
            System.out.print(String.valueOf((char) (i + 64)));
            for (int j = 1; j < 21; j++) {
                if (j % 2 == 0) {
                    System.out.print(board[i - 1][(j - 1) / 2]);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    public boolean spaceForShip(Coord start, Coord end) {
        // establish ship is horizontal or vertical
        // establish space for ship
        if (Coord.areCoordsHorizontal(start, end)) {
            for (int col = start.getCol(); col < end.getCol(); col += 2) {
                if (!board[start.getRow()][col].equals("~")) {
                    return false;
                }
            }
            return true;
        } else {
            if (start.getRow() < end.getRow()) {
                for (int row = start.getRow(); row < end.getRow(); row++) {
                    if (!board[row][start.getCol()].equals("~")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean inputShipVertically(Coord start, Coord end) {
        if (!Coord.areCoordsHorizontal(start, end)) {
            for (int row = start.getRow(); row < end.getRow(); row++) {
                board[row][start.getCol()] = "0";
            }
            return true;
        }
        return false;
    }

    public boolean inputShipHorizontally(Coord start, Coord end) {
        if (Coord.areCoordsHorizontal(start, end)) {
            for (int col = start.getCol(); col < end.getCol(); col += 2) {
                board[start.getRow()][col] = "0";
                return true;
            }
        }
        return false;
    }
}
