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
            for (int col = start.getCol(); col < end.getCol(); col++) {
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

    public boolean inputShip(Coord start, Coord end, Ship ship) {
        if (!Coord.isLengthCorrect(start, end, ship)) {
            System.out.println("Error: Co-ordinates are incorrect for length of ship: " + ship.getShip());
            return false;
        } else if (!Coord.areCoordsHorizontal(start, end)) {
            // Inputting ship vertically
            for (int row = start.getRow(); row <= end.getRow(); row++) {
                board[row][start.getCol()] = "0";
            }
            return true;
        } else {
            // inputting ship horizontally
            for (int col = start.getCol(); col <= end.getCol(); col++) {
                board[start.getRow()][col] = "0";
            }
            return true;
        }
    }
}
