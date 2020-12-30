package battleship;

import java.util.Scanner;

public class GameLoop {
    private final Scanner scanner;
    private final GameBoard game;
    private final ShipType[] ships = {
            ShipType.AircraftCarrier,
            ShipType.BattleShip,
            ShipType.Submarine,
            ShipType.Cruiser,
            ShipType.Destroyer
    };
    private static GameLoop instance;

    private GameLoop(GameBoard game) {
        this.scanner = new Scanner(System.in);
        this.game = game;
    }

    public static GameLoop getInstance(GameBoard game) {
        if (instance == null) {
            instance = new GameLoop(game);
        }
        return instance;
    }

    public void Run() {
        placeAllShips();
        System.out.println(Message.START.getText());
        game.printFogBoard();

        takeShotsUntilWon();
    }

    private void takeShotsUntilWon() {
        boolean won = false;
        System.out.println(Message.SHOT.getText());
        while (!won) {
            won = takeShot();
        }
    }

    private void placeAllShips() {
        for (ShipType ship : ships) {
            System.out.println(
                    "Enter the coordinates of the "
                            + ship.getName()
                            + " ("
                            + ship.getCells()
                            + " cells):"
            );
            placeShipOnBoard(ship);
            game.printBoard();
        }
    }

    private void placeShipOnBoard(ShipType ship) {
        boolean complete = false;
        while (!complete) {
            Coord[] shipPlacement = parseShipPlacement(scanner);
            Coord start = shipPlacement[0];
            Coord end = shipPlacement[1];
            if (GameBoard.doCoordsAscend(start, end)) {
                complete = game.inputShip(start, end, ship);
            } else {
                complete = game.inputShip(end, start, ship);
            }
        }
    }

    private static Coord[] parseShipPlacement(Scanner sc) {
        String[] input = sc.nextLine().toUpperCase().split(" ");
        Coord[] output = {
                new Coord(input[0]),
                new Coord(input[1])
        };
        return output;
    }

    private static Coord parseShotCoord(Scanner sc) {
        return new Coord(sc.nextLine().toUpperCase());
    }

    private boolean takeShot() {
        Coord shot = parseShotCoord(scanner);
        if (shot.invalidCoord()) {
            System.out.println(Message.ERROR.getText());
            return false;
        } else {
            if (missedShot(shot)) {
                handleMissedShot(shot);
            } else if (successfulShot(shot)) {
                handleSuccessfulShot(shot);
            } else {
                System.out.println(Message.ERROR.getText());
                return false;
            }
            if (areAllShipsSunk()) {
                System.out.println(Message.WIN.getText());
                return true;
            }
            return false;
        }
    }

    private boolean areAllShipsSunk() {
        return ShipType.getSunkCount() == ships.length;
    }

    private boolean missedShot(Coord shot) {
        return game.board[shot.getRow()][shot.getCol()].equals(CellData.FOG.getDisplay());
    }

    private void handleMissedShot(Coord shot) {
        game.board[shot.getRow()][shot.getCol()] = CellData.MISSED.getDisplay();
        game.printFogBoard();
        System.out.println(Message.MISS.getText());
    }

    private boolean successfulShot(Coord shot) {
        return game.board[shot.getRow()][shot.getCol()].equals(CellData.SHIP.getDisplay())
                || game.board[shot.getRow()][shot.getCol()].equals(CellData.HIT.getDisplay());
    }

    private void handleSuccessfulShot(Coord shot) {
        game.board[shot.getRow()][shot.getCol()] = CellData.HIT.getDisplay();
        game.printFogBoard();
        System.out.println(Message.HIT.getText());
        establishShipHit(shot);
    }

    private void establishShipHit(Coord shot) {
        for (ShipType ship : ships) {
            if (ship.isHorizontal()) {
                if (shotHitsHorizontalShip(shot, ship)) {
                    hitShip(ship);
                }
            } else {
                if (shotHitsVerticalShip(shot, ship)) {
                    hitShip(ship);
                }
            }
        }
    }

    private static boolean shotHitsHorizontalShip(Coord shot, ShipType ship) {
        boolean isRowSame = shot.getRow() == ship.getStart().getRow();
        boolean isShotWithinLeftBound = shot.getCol() >= ship.getStart().getCol();
        boolean isShotWithinRightBound = shot.getCol() <= ship.getEnd().getCol();
        return isShotWithinLeftBound && isShotWithinRightBound && isRowSame;
    }

    private static boolean shotHitsVerticalShip(Coord shot, ShipType ship) {
        boolean isColumnSame = shot.getCol() == ship.getStart().getCol();
        boolean isShotWithinTopBound = shot.getRow() >= ship.getStart().getRow();
        boolean isShotWithinBottomBound = shot.getRow() <= ship.getEnd().getRow();
        return isShotWithinTopBound && isShotWithinBottomBound && isColumnSame;
    }

    private void hitShip(ShipType ship) {
        ship.hitCell();
        if (ship.isSunk()) {
            System.out.println(Message.SANK.getText());
        }
    }
}
