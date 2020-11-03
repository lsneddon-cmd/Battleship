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

    public static boolean isShipHorizontal(Coord start, Coord end) {
        return start.getRow() == end.getRow();
    }

    public boolean spaceForShip(Ship battleShip, Coord start, Coord end) {
        // establish ship is horizontal or vertical
        // establish space around ship
        if (isShipHorizontal(start, end)) {

        } else {

        }
    }

    public void addShipToGame(Ship battleShip, Coord start, Coord end) {
        // Ships should not cross
        // Ships should not touch each other
    }
}
