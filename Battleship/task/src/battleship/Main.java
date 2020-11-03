package battleship;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        GameBoard game = new GameBoard();
        game.printBoard();

        Coord a1 = new Coord("A1");
        System.out.println(a1.isValidCoord());
        System.out.println(a1.getCol());
        System.out.println(a1.getRow());
    }
}
