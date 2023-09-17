package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.minesweeper_cli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * <div>
 *     <p>
 *         Minesweeper game, board size is {@code columnCount} x {@code rowCount}
 *         and contains {@code numberOfMines} mines.
 *     </p>
 *     <p>
 *         The initial input is the {@code columnCount} and {@code rowCount}
 *         of the board, plus the number of mines that are hidden across
 *         the mine-field.
 *     </p>
 *     <h3>Initial visibleBoard state for Beginner 9x9</h3>
 * <pre>
 *            0   1   2   3   4   5   6   7   8
 *          +---+---+---+---+---+---+---+---+---+
 *      0   |   |   |   |   |   |   |   |   |   |
 *      1   |   |   |   |   |   |   |   |   |   |
 *      2   |   |   |   |   |   |   |   |   |   |
 *      3   |   |   |   |   |   |   |   |   |   |
 *      4   |   |   |   |   |   |   |   |   |   |
 *      5   |   |   |   |   |   |   |   |   |   |
 *      6   |   |   |   |   |   |   |   |   |   |
 *      7   |   |   |   |   |   |   |   |   |   |
 *      8   |   |   |   |   |   |   |   |   |   |
 *          +---+---+---+---+---+---+---+---+---+
 * </pre>
 *
 * </div>
 */
@Data
public class MinesweeperCli {
    private final GameLevelEnum gameLevel;
    private final int columnCount;
    private final int rowCount;
    private final int numberOfMines;

    private boolean gameInProgress = true;
    private GameState gameState = GameState.ON_GOING;

    private int[][] hiddenBoard;
    private Cell[][] visibleBoard;

    private int cellsLeft;

    public MinesweeperCli(GameLevelEnum gameLevel) {
        this.gameLevel = gameLevel;
        this.columnCount = gameLevel.getWidth();
        this.rowCount = gameLevel.getHeight();
        this.numberOfMines = gameLevel.getNumberOfMines();
        this.cellsLeft = gameLevel.getWidth() * gameLevel.getHeight();

        visibleBoard = initUserBoard();
        hiddenBoard = initMinefield();

        this.printMinefield();
        this.printUserBoard();

    }

    public static void main(String[] args) {
        MinesweeperCli minesweeperCli = new MinesweeperCli(GameLevelEnum.BEGINNER);

        final Scanner scanner = new Scanner(new InputStreamReader(System.in));

        while (minesweeperCli.getGameState().equals(GameState.ON_GOING)) {
            System.out.println("Enter your move in the format of \"row-number column-number\" ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("quit")) {
                minesweeperCli.setGameInProgress(false);
                continue;
            }
            String[] strings = userInput.split(" ");
            int row;
            int column;
            if (strings.length == 2) {
                try {
                    row = Integer.parseInt(strings[0]);
                    column = Integer.parseInt(strings[1]);
                } catch (NumberFormatException e) {
                    System.out.println("You input \"" + userInput + "\" is invalid, try again");e.printStackTrace();
                    continue;
                }
                minesweeperCli.enterMove(row, column);
            }
        }
    }

    private void enterMove(final int row, final int column) {
        Cell cellSelected = this.visibleBoard[row][column];
        if (cellSelected.isOpened())
            System.out.printf("You already opened the cell at row: %d and column: %d, try another location.%n", row, column);

        cellSelected.setOpened(true);
    }

    /**
     *  NW  N  NE   NW = row-1,column-1 ; N (North) = row-1, column ; NE = row-1, column+1
     *    \ | /
     *  W - X - E   W (West) = row, column-1 ; E (East) = row, column+1
     *    / | \
     *  SW  S  SE   SW = row+1, column-1 ; S (South) = row+1, column ; SE = row+1, column+1
     *
     * @param row
     * @param column
     */
    private int checkCell(final int row, final int column) {
        if (this.visibleBoard[row][column].isOpened())
            return -1;
        else
            this.cellsLeft--;

        if (this.visibleBoard[row][column].isMined()) {
            this.setGameState(GameState.FAILURE);
            return -2;
        }

        if (this.getCellsLeft() == 0) {
            this.setGameState(GameState.SUCCESSFUL);
            return Integer.MAX_VALUE;
        }

        //  NW / North-West
        if (isValidCell(row-1, column-1) && !this.visibleBoard[row-1][column-1].isOpened()) {
            int result = checkCell(row-1, column-1);
            if (result == -2) return result;
        }

        //  N / North
        if (isValidCell(row-1, column) && !this.visibleBoard[row-1][column].isOpened()) {
            int result = checkCell(row-1, column);
            if (result == -2) return result;

        }

        //  NE / North-East
        if (isValidCell(row-1, column+1) && !this.visibleBoard[row-1][column+1].isOpened()) {
            int result = checkCell(row-1, column+1);
            if (result == -2) return result;

        }

        //  W / West
        if (isValidCell(row, column-1) && !this.visibleBoard[row][column-1].isOpened()) {
            int result = checkCell(row, column-1);
            if (result == -2) return result;

        }

        //  E / East
        if (isValidCell(row, column+1) && !this.visibleBoard[row][column+1].isOpened()) {
            int result = checkCell(row, column+1);
            if (result == -2) return result;

        }

        //  SW / South-West
        if (isValidCell(row+1, column-1) && !this.visibleBoard[row+1][column-1].isOpened()) {
            int result = checkCell(row+1, column-1);
            if (result == -2) return result;

        }

        //  S / South
        if (isValidCell(row+1, column) && !this.visibleBoard[row+1][column].isOpened()) {
            int result = checkCell(row+1, column);
            if (result == -2) return result;

        }

        //  SE / South-East
        if (isValidCell(row+1, column+1) && !this.visibleBoard[row+1][column+1].isOpened()) {
            int result = checkCell(row+1, column+1);
            if (result == -2) return result;
        }
        return 9999999;
    }

    private boolean isValidCell(final int row, final int column) {
        return row >= 0 && row < this.getRowCount() && column >=0 && column < this.getColumnCount();
    }

    private Cell[][] initUserBoard() {
        final int width = this.getColumnCount();
        final int height = this.getRowCount();
        Cell newCell = new Cell(0,0,false,false,false,0,CellType.EMPTY);
        Cell[][] arrCells = new Cell[width][height];
        for (int y = 0; y < this.getRowCount(); y++) {
            for (int x = 0; x < this.getColumnCount(); x++) {
                newCell.setRowCoordinate(y);
                newCell.setColumnCoordinate(x);
                arrCells[y][x] = newCell;
            }
        }
        return arrCells;
    }

    /**
     * <div>
     *     <p>Setup the minefield, locate the mines in random places.</p>
     * </div>
     */
    private int[][] initMinefield() {
        int[][] minefield = new int[this.getColumnCount()][this.getRowCount()];
        for (int minesPlaced = 0; minesPlaced < this.getNumberOfMines(); minesPlaced++) {
            //int row = new Random().nextInt();
            int row = (int)Math.floor(Math.random() * (this.getRowCount()  + 1));
            //int column = new Random().nextInt();
            int column = (int)Math.floor(Math.random() * (this.getColumnCount()  + 1));
            if (row >= 0 && row < this.getRowCount() && column >= 0 && column < this.getRowCount())
                minefield[row][column] = 1;
            else
                System.out.println("column = " + column + " ; row = " + row);
        }
        return minefield;
    }

    private void printLineSeparator() {
        System.out.println("   +---+---+---+---+---+---+---+---+---+");
    }
    private void printUserBoard() {
        System.out.println("\n     -=#  Mine Sweeper - Game Board  #=-");
        System.out.println("     0   1   2   3   4   5   6   7   8  ");
        printLineSeparator();
        for (int y = 0; y < this.getRowCount(); y++) {
            System.out.print(" " + y + " ");
            for (int x = 0; x < this.getColumnCount(); x++) {
                //  This will be printed by default if !isOpen() if !isOpened()
                String string = " ";
                if (this.visibleBoard[y][x].isOpened())
                    if (this.visibleBoard[y][x].isMined())
                        string = "M";
                    else if (this.visibleBoard[y][x].isFlagged())
                        string = "F";
                    else if (this.visibleBoard[y][x].getNeighborMineCount() != 0)
                        string = String.valueOf(this.visibleBoard[y][x].getNeighborMineCount());
                System.out.printf("| %s ", string);
            }
            System.out.println("|");
        }
        printLineSeparator();
    }

    private void printMinefield() {
        System.out.println("\n     -=# Minesweeper - The Minefield #=-");
        System.out.println("     0   1   2   3   4   5   6   7   8  ");
        printLineSeparator();
        for (int y = 0; y < this.getRowCount(); y++) {
            System.out.print(" " + y + " ");
            for (int x = 0; x < this.getColumnCount(); x++) {
                System.out.print("| " + (this.hiddenBoard[y][x] == 1 ? "# " : "  "));
            }
            System.out.println("|");
        }
        printLineSeparator();
    }

    @Getter
    @AllArgsConstructor
    enum CellType {
        MINED("Mined"),
        EMPTY("Empty");

        private String value;
    }

    enum GameState {
        ON_GOING, FAILURE, SUCCESSFUL;
    }

    @Getter
    enum GameLevelEnum {
        BEGINNER("Beginner", 9, 9, 10),
        INTERMEDIATE("Intermediate", 16, 16, 40),
        EXPERT("Expert", 24, 24, 99);

        private final String name;
        private final int width;
        private final int height;
        private final int numberOfMines;

        GameLevelEnum(String name, int width, int height, int numberOfMines) {
            this.name = name;
            this.width = width;
            this.height = height;
            this.numberOfMines = numberOfMines;
        }
    }

    @Data
    @AllArgsConstructor
    class Cell {
        private int columnCoordinate;
        private int rowCoordinate;
        private boolean opened;
        private boolean flagged;
        private boolean mined;
        private int neighborMineCount;

        private CellType cellType;

        public Cell() {
            this.columnCoordinate = 0;
            this.rowCoordinate = 0;
            this.opened = false;
            this.flagged = false;
            this.mined = false;
            this.neighborMineCount = 0;
        }
    }

}
