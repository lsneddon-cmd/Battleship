package battleship;

public class GameBoard {
    String[][] board = new String[11][21];

    public GameBoard() {
        board[0][0] = " ";
        for (int i = 1; i < 21; i += 2) {
            board[0][i] = " ";
        }
        for (int i = 2; i < 21; i += 2) {
            board[0][i] = String.valueOf(i / 2);
        }
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 21; j++) {
                if (j % 2 == 0) {
                    board[i][j] = "~";
                } else {
                    board[i][j] = " ";
                }
            }
        }
        for (int i = 1; i < 11; i++) {
            board[i][0] = String.valueOf((char) (i + 64));
        }
    }

    public void printBoard() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(board[i][j]);
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
        for (int row = start.getRow(); row < end.getRow(); row++) {
            board[row][start.getCol()] = "0";
        }
        return true;
    }
}
