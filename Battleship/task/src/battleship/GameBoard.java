package battleship;

public class GameBoard {
    String[][] board = new String[10][10];

    public GameBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = CellData.FOG.getDisplay();
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

    public void printFogBoard() {
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
                    if (board[i - 1][(j - 1) / 2].equals(CellData.SHIP.getDisplay())) {
                        System.out.print(CellData.FOG.getDisplay());
                    } else {
                        System.out.print(board[i - 1][(j - 1) / 2]);
                    }
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    private boolean spaceForShip(Coord start, Coord end) {
        for (int row = start.getRow() - 1; row <= end.getRow() + 1; row++) {
            if (intOutOfBoundsForGrid(row)) {
                continue;
            }
            for (int col = start.getCol() - 1; col <= end.getCol() + 1; col++) {
                if (intOutOfBoundsForGrid(col)) {
                    continue;
                }
                if (!isCellWater(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean intOutOfBoundsForGrid(int i) {
        return i < 0 || i > 9;
    }

    private boolean isCellWater(int row, int col) {
        return board[row][col].equals(CellData.FOG.getDisplay());
    }

    public boolean inputShip(Coord start, Coord end, ShipType ship) {
        if (areCoordsDiagonal(start, end)) {
            System.out.println("Error: Co-ordinates entered are diagonal");
            return false;
        }
        if (!isLengthCorrect(start, end, ship)) {
            System.out.println("Error: Co-ordinates are incorrect for length of ship: "
                    + ship.getName());
            System.out.println("This ship takes "
                    + ship.getCells()
                    + " cells.");
            return false;
        }
        if (!spaceForShip(start, end)) {
            System.out.println("Error: No space for ship");
            return false;
        }
        if (!areCoordsHorizontal(start, end)) {
            // Inputting ship vertically
            inputShipVertically(start, end);
            ship.setHorizontal(false);
            ship.setStart(start);
            ship.setEnd(end);
            return true;
        } else  {
            // inputting ship horizontally
            inputShipHorizontally(start, end);
            ship.setHorizontal(true);
            ship.setStart(start);
            ship.setEnd(end);
            return true;
        }
    }

    private void inputShipVertically(Coord start, Coord end) {
        for (int row = start.getRow(); row <= end.getRow(); row++) {
            board[row][start.getCol()] = CellData.SHIP.getDisplay();
        }
    }

    private void inputShipHorizontally(Coord start, Coord end) {
        for (int col = start.getCol(); col <= end.getCol(); col++) {
            board[start.getRow()][col] = CellData.SHIP.getDisplay();
        }
    }

    private static boolean isLengthCorrect(Coord start, Coord end, ShipType ship) {
        if (areCoordsHorizontal(start, end)) {
            return Math.abs(start.getCol() - end.getCol()) + 1 == ship.getCells();
        } else {
            return Math.abs(start.getRow() - end.getRow()) + 1 == ship.getCells();
        }
    }

    private static boolean areCoordsHorizontal(Coord start, Coord end) {
        return start.getRow() == end.getRow();
    }

    private static boolean areCoordsDiagonal(Coord start, Coord end) {
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
