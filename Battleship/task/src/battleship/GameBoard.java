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
        for (int row = start.getRow() - 1; row <= end.getRow() + 1; row++) {
            if (row < 0 || row > 9) {
                continue;
            }
            for (int col = start.getCol() - 1; col <= end.getCol() + 1; col++) {
                if (col < 0 || col > 9) {
                    continue;
                }
                if (!board[row][col].equals("~")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean inputShip(Coord start, Coord end, Ship ship) {
        if (areCoordsDiagonal(start, end)) {
            System.out.println("Error: Co-ordinates entered are diagonal");
            return false;
        }
        if (!isLengthCorrect(start, end, ship)) {
            System.out.println("Error: Co-ordinates are incorrect for length of ship: " + ship.getShip());
            return false;
        }
        if (!spaceForShip(start, end)) {
            System.out.println("Error: No space for ship");
            return false;
        }
        if (!areCoordsHorizontal(start, end)) {
            // Inputting ship vertically
            inputShipVertically(start, end);
            return true;
        } else  {
            // inputting ship horizontally
            inputShipHorizontally(start, end);
            return true;
        }
    }

    public void inputShipVertically(Coord start, Coord end) {
        for (int row = start.getRow(); row <= end.getRow(); row++) {
            board[row][start.getCol()] = "O";
        }
    }

    public void inputShipHorizontally(Coord start, Coord end) {
        for (int col = start.getCol(); col <= end.getCol(); col++) {
            board[start.getRow()][col] = "O";
        }
    }

    public static boolean isLengthCorrect(Coord start, Coord end, Ship ship) {
        if (areCoordsHorizontal(start, end)) {
            return Math.abs(start.getCol() - end.getCol()) + 1 == ship.getCells();
        } else {
            return Math.abs(start.getRow() - end.getRow()) + 1 == ship.getCells();
        }
    }

    public static boolean areCoordsHorizontal(Coord start, Coord end) {
        return start.getRow() == end.getRow();
    }

    public static boolean areCoordsDiagonal(Coord start, Coord end) {
        return !(start.getRow() == end.getRow() || start.getCol() == end.getCol());
    }

    public static boolean doCoordsAscend(Coord start, Coord end) {
        if (areCoordsHorizontal(start, end)) {
            return start.getCol() < end.getCol();
        } else {
            return start.getRow() < end.getRow();
        }
    }


}
