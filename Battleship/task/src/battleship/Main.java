package battleship;

public class Main {

    public static void main(String[] args) {

        GameBoard game = new GameBoard();

        GameLoop gameLoop = GameLoop.getInstance(game);

        gameLoop.Run();
    }


}
