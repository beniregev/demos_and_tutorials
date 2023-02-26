package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.minesweeper1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

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
 *      0   | ? | ? | ? | ? | ? | ? | ? | ? | ? |
 *      1   | ? | ? | ? | ? | ? | ? | ? | ? | ? |
 *      2   | ? | ? | ? | ? | ? | ? | ? | ? | ? |
 *      3   | ? | ? | ? | ? | ? | ? | ? | ? | ? |
 *      4   | ? | ? | ? | ? | ? | ? | ? | ? | ? |
 *      5   | ? | ? | ? | ? | ? | ? | ? | ? | ? |
 *      6   | ? | ? | ? | ? | ? | ? | ? | ? | ? |
 *      7   | ? | ? | ? | ? | ? | ? | ? | ? | ? |
 *      8   | ? | ? | ? | ? | ? | ? | ? | ? | ? |
 * </pre>
 *
 * </div>
 */
@Data
public class MineSweeper {
    private final GameLevelEnum gameLevel;
    private final int columnCount;
    private final int rowCount;
    private final int numberOfMines;

    private int[][] hiddenBoard;
    private Cell[][] visibleBoard;

    private int cellsLeft;

    public MineSweeper(GameLevelEnum gameLevel) {
        this.gameLevel = gameLevel;
        this.columnCount = gameLevel.getWidth();
        this.rowCount = gameLevel.getHeight();
        this.numberOfMines = gameLevel.getNumberOfMines();
        this.cellsLeft = gameLevel.getWidth() * gameLevel.getHeight();

        visibleBoard = initUserBoard();
        hiddenBoard = initMinefield();

        this.printMinefield();


    }

    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeper(GameLevelEnum.BEGINNER);
    }

    private Cell[][] initUserBoard() {
        final int width = this.getColumnCount();
        final int height = this.getRowCount();

        Cell[][] arrCells = new Cell[width][height];
        for (int y = 0; y < this.getRowCount(); y++) {
            for (int x = 0; x < this.getColumnCount(); x++) {
                arrCells[y][x] = Cell.builder()
                        .rowCoordinate(y)
                        .columnCoordinate(x)
                        .opened(false)
                        .flagged(false)
                        .mined(false)
                        .neighborMineCount(0)
                        .cellType(CellType.EMPTY)
                        .build();
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

    private void printMinefield() {
        System.out.println("-=# Welcome To Minesweeper #=-");
        System.out.println("     0   1   2   3   4   5   6   7   8  ");
        System.out.println("   +---+---+---+---+---+---+---+---+---+");
        for (int y = 0; y < this.getRowCount(); y++) {
            System.out.print(" " + y + " ");
            for (int x = 0; x < this.getColumnCount(); x++) {
                System.out.print("| " + (this.hiddenBoard[y][x] == 1 ? "# " : "  "));
            }
            //System.out.println("|\n-------------------------------------");
            System.out.println("|");
        }
        System.out.println("   +---+---+---+---+---+---+---+---+---+");
    }

    @Getter
    @AllArgsConstructor
    enum CellType {
        MINED("Mined"),
        EMPTY("Empty");

        private String value;
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

    @Builder
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
